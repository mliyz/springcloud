package com.liyz.common.util.excel;



import com.liyz.common.util.excel.formatter.ValueFormatter;
import com.liyz.common.util.excel.wraper.DataWraper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * 基于模板的Excel导出类
 * 用法：
 * TemplatedExcelExporter exp = new TemplatedExcelExporter();
 * exp.addColumn(0,"field").addColumn(1,"field2").....;
 * exp.setDataWraper(new );
 * exp.output(os);
 * */
public class TemplatedExcelExporter {
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplatedExcelExporter.class);
	private List<TemplatedExcelColumn> columns = new ArrayList<>();//excel中的列
	private DataWraper dataWraper;//数据包装器，可包含List,ResultSet类型的数据
	private int dataStartRowIndex = 1;//数据输出的默认行索引,标题多于1行，用户需要自行设置该值
	private Workbook wb;//Excel工作簿对象
	private ExcelEditHandler excelEditHandler = new EmptyEditHandler();//在创建excel后对Excel编辑的入口，EmptyEditHandler为默认实现，什么都不做
	public DataWraper getDataWraper() {
		return dataWraper;
	}

	public void setDataWraper(DataWraper dataWraper) {
		this.dataWraper = dataWraper;
	}
	
	/**
	 * 设置Excel处理的实现
	 * @param excelEditHandler
	 */
	public void setExcelEditHandler(ExcelEditHandler excelEditHandler) {
		this.excelEditHandler = excelEditHandler;
	}

	public int getDataStartRowIndex() {
		return dataStartRowIndex;
	}

	public void setDataStartRowIndex(int dataStartRowIndex) {
		this.dataStartRowIndex = dataStartRowIndex;
	}

	/**
	 * 增加一列，使用默认的格式化器
	 * @param columnIndex
	 * @param field
	 * @return
	 */
	public TemplatedExcelExporter addColumn(int columnIndex,String field){
		this.columns.add(new TemplatedExcelColumn(columnIndex,field));
		return this;
	}
	
	/**
	 * 增加一列，使用指定的格式化器
	 * @param columnIndex 列索引
	 * @param field 字段名称
	 * @param valueFormatter 格式化器对象
	 * @return
	 */
	public TemplatedExcelExporter addColumn(int columnIndex,String field,ValueFormatter valueFormatter){
		this.columns.add(new TemplatedExcelColumn(columnIndex,field,valueFormatter));
		return this;
	}
	
	/**
	 * 根据数据和列的信息，构建excel工作簿
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	private void createExcel(InputStream templateInputStream) {
		//建立工作簿
		try {
			this.wb = WorkbookFactory.create(templateInputStream);
		} catch (InvalidFormatException | IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		//wb = new SXSSFWorkbook(100); //keep 100 rows in memory, exceeding rows will be flushed to disk
		if(wb.getNumberOfSheets() == 0){
			throw new IllegalStateException("模板excel文件无sheet页");
		}
		Sheet sheet = wb.getSheetAt(0);
		
		TemplatedExcelColumn excelCol;
		Cell cell;
		Row row;
		int rowIndex = this.dataStartRowIndex;//行的索引值,使用设置的数据行开始索引值，一般为1，标题为多行的，用户自行设置
		
		//输出数据
		Object rowData = null;//该行的数据
		Object value;
		while(dataWraper.next()){
			rowData = dataWraper.getRowData();
			
			row = sheet.createRow(rowIndex++);
			
			//循环列输出数据
			for(int i=0;i<columns.size();i++){
				excelCol = columns.get(i);
				value = dataWraper.getFieldValue(excelCol.getFieldName());//调用封装器内的获取字段的方法获得字段值
				if(value != null){
					//cell = row.createCell(excelCol.getIndex());//直接使用ExcelColumn中的索引值创建Cell
					cell = fixCell(row,excelCol.getIndex());
					Object formatValue = excelCol.getValueFormatter().format(value,rowData);
					if(formatValue instanceof Integer){
						cell.setCellValue(Double.parseDouble(formatValue.toString()));
					}else{
						cell.setCellValue((String)formatValue);
					}
//					cell.setCellValue(excelCol.getValueFormatter().format(value,rowData));
				}
			}
		}
		
	}
	
	/**
	 * 根据行(row)和列索引获取一个单元格,没有则创建
	 * @param row Excel row
	 * @param cellIndex 列索引
	 * @return 指定位置的单元格
	 */
	Cell fixCell(Row row,int cellIndex){
		Cell cell = row.getCell(cellIndex);
		if(cell == null){
			cell = row.createCell(cellIndex);
		}
		return cell;
	}
	
	
	/**
	 * @param os 输出流
	 * @param templateFileInputStream Excel模板文件的输入流
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public void output(OutputStream os,InputStream templateFileInputStream) {
		this.createExcel(templateFileInputStream);//创建excel
		
		this.excelEditHandler.edit(this.wb);//编辑Excel的钩子
		
		//主要方法,输出到输出流中
		try {
			this.wb.write(os);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		this.clean(templateFileInputStream);
	}
	
	/**
	 * @param os 输出流
	 * @param templateFile Excel模板文件的路径
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public void output(OutputStream os,String templateFile) throws Exception{
		FileInputStream templateFileInputStream = new FileInputStream(templateFile);
		this.output(os, templateFileInputStream);//调用重载的方法
	}
	
	/**
	 * 清理模板输入流(关闭)
	 * @param ins 模板输入流
	 */
	private void clean(InputStream ins){
		try {
			if(ins != null){
				ins.close();
			}
		}catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
}
