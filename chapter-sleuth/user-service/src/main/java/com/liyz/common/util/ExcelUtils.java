package com.liyz.common.util;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


/**
 * Excel导出Util
 *
 * Package : com.yixin.nssp.util
 *
 * @author YixinCapital -- xieguanjie
 *		   2017年9月6日 上午11:33:53
 *
 */

public class ExcelUtils {
	
	protected final static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 导出数据
     * @param listTitleName
     * @param strDataList
     * @return
     */
    public static byte[] exportData(List<String> listTitleName,List<String[]> strDataList) {
        //第一步创建workbook
        XSSFWorkbook wb = new XSSFWorkbook();

        //第二部创建sheet页，并设置标题名称
        Sheet sheet = createXSSFSheetTitleRow(wb, listTitleName);

        //第三步定义每个单元格的样式
        CellStyle  style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);  //居中

        //第四步循环设置每个列下面的值
        for (int dataRow = 0; dataRow < strDataList.size() ; dataRow++) {
            String[] one = strDataList.get(dataRow);
            //创建一行
            Row row = sheet.createRow(dataRow+1);
            //创建每一列，并根据标题顺序对字段进行匹配
            for(int i=0;i<one.length;i++){
                Cell cell0 = row.createCell(i);
                cell0.setCellValue(one[i]);
                cell0.setCellStyle(style);
            }
        }

        //第五步转成流并返回
        byte[] filebyte = HSSFWorkbookCaseByteArray(wb);
        return filebyte;
    }
	
	/**
	 * 把work转成byte数组
	 *
	 * @param wb word
	 * @return
	 * @author YixinCapital -- buxiangpeng
	 *	       2017年10月11日 下午6:52:22
	 */
	private static byte[] HSSFWorkbookCaseByteArray(XSSFWorkbook wb) {
		byte[] filebyte = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
 		try {
 			wb.write(out);
 			filebyte = out.toByteArray();
 		} catch (IOException e) {
 			e.printStackTrace();
 			logger.error("将生成excel文件转成流失败:{}", e);
 		} finally {//使用finally块来关闭输出流
 			try {
 				if (out != null) {
 					out.close();
 				}
 			} catch (IOException ex) {
 				ex.printStackTrace();
 				logger.error("使用finally块来关闭输出流失败:{}", ex);
 			}
 		}
		return filebyte;
	}
	
	/**
	 * 创建sheet页，并设置title名称
	 * @param wb HSSFWorkbook
	 * @param listTitleName 标题名称list集合
	 * @return
	 * @author YixinCapital -- buxiangpeng
	 *	       2017年10月11日 下午6:41:55
	 */
	private static Sheet createXSSFSheetTitleRow(XSSFWorkbook wb,List<String> listTitleName) {
		//第一步创建sheet,并设置sheet名称
		Sheet sheet = wb.createSheet();
		for(int i = 0 ; i < listTitleName.size() ; i++) {
			sheet.setColumnWidth(i, 20 * 250);
		}
		
		//第二步定义每个单元格的样式
        CellStyle  style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);  //居中
        Font font = wb.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);//标题加粗
        style.setFont(font);
		
		//第三步创建标题行:添加表头第0行
        Row row1 = sheet.createRow(0);
		
        //第四步循环设置每列的标题名称，并设设置样式
        for(int i = 0 ; i < listTitleName.size() ; i++) {
        	Cell cell = row1.createCell(i);
    		cell.setCellValue(listTitleName.get(i));
    		cell.setCellStyle(style);
        }
		return sheet;
	}
	
}
