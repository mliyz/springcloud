package com.liyz.common.util.excel;


import com.liyz.common.util.DateUitls;
import com.liyz.common.util.excel.formatter.ValueFormatter;
import com.liyz.common.util.excel.wraper.DataWraper;
import com.liyz.common.util.exception.BzException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author lishuaifeng
 *
 */
public class ExportExcel {
	private static Logger logger = LoggerFactory.getLogger(ExportExcel.class);
	/**
	 * 生成excel输出流
	 * @param excelFileName 	例如"匹配结果"
	 * @param templetLoc  		例如："templates/excel/matched_moddle.xls"
	 * @param dataWraper		例如：new PojoListDataWraper(list)
	 * @param colNames  Map中的key或者pojo中的属性名 顺序与模板中字段顺序对应			例如["branchCompanyName","joinShopName"]
	 * @return
	 */
	public static ResponseEntity<byte[]> getResponseEntity(String excelFileName, String templetLoc, DataWraper dataWraper, String[] colNames){
		ByteArrayOutputStream os = new ByteArrayOutputStream();// 输出流，最终返回用
		HttpHeaders headers = new HttpHeaders();
		try {
			final MediaType mediaType = MediaType
					.parseMediaType("application/force-download;charset=UTF-8");// 强制下载mediatype
			headers.setContentType(mediaType);
			String fileName =excelFileName +"_"+ DateUitls.dateToStr(new Date(), "yyyyMMdd") + "."+templetLoc.split("\\.")[1];
			fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
			headers.setContentDispositionFormData("attachment", fileName);
			// 设置导出的属性
			TemplatedExcelExporter exporter = new TemplatedExcelExporter();
			for(int i=0;i<colNames.length;i++){
				exporter.addColumn(i, colNames[i]);
			}
			exporter.setDataStartRowIndex(1); // 开始输出的行索引为1
			exporter.setDataWraper(dataWraper);// 设置数据

			InputStream is = ExportExcel.class.getClassLoader()
					.getResourceAsStream(templetLoc);
			exporter.output(os, is);
			logger.info("{},数据导出到excel成功！",excelFileName);
			return new ResponseEntity<byte[]>(os.toByteArray(), headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("生成Excel文件过程发生异常，信息为：{}",e);
			throw new BzException("生成Excel文件过程发生异常");
		}
		
	}
	/**
	 * 带字段格式化生成excel输出流
	 * @param excelFileName 	例如"匹配结果"
	 * @param templetLoc  		例如："templates/excel/matched_moddle.xls"
	 * @param dataWraper		例如：new PojoListDataWraper(list)
	 * @param colNames  Map中的key或者pojo中的属性名 顺序与模板中字段顺序对应			例如["branchCompanyName","joinShopName"]
	 * @param formatterMap 字段格式化
	 * @return
	 */
	public static ResponseEntity<byte[]> getResponseEntity(String excelFileName,String templetLoc,DataWraper dataWraper,
			String[] colNames,Map<String,ValueFormatter> formatterMap){
		ByteArrayOutputStream os = new ByteArrayOutputStream();// 输出流，最终返回用
		HttpHeaders headers = new HttpHeaders();
		try {
			final MediaType mediaType = MediaType
					.parseMediaType("application/force-download;charset=UTF-8");// 强制下载mediatype
			headers.setContentType(mediaType);
			String fileName =excelFileName +"_"+ DateUitls.dateToStr(new Date(), "yyyyMMdd") + "."+templetLoc.split("\\.")[1];
			fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
			headers.setContentDispositionFormData("attachment", fileName);
			// 设置导出的属性
			TemplatedExcelExporter exporter = new TemplatedExcelExporter();
			for(int i=0;i<colNames.length;i++){
				if(formatterMap.get(colNames[i])!=null){
					exporter.addColumn(i, colNames[i], formatterMap.get(colNames[i]));
				}else{
					exporter.addColumn(i, colNames[i]);
				}
			}
			exporter.setDataStartRowIndex(1); // 开始输出的行索引为1
			exporter.setDataWraper(dataWraper);// 设置数据

			InputStream is = ExportExcel.class.getClassLoader()
					.getResourceAsStream(templetLoc);
			exporter.output(os, is);
			logger.info("{},数据导出到excel成功！",excelFileName);
			return new ResponseEntity<byte[]>(os.toByteArray(), headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("生成Excel文件过程发生异常，信息为：{}",e);
			throw new BzException("生成Excel文件过程发生异常");
		}
		
	}
}
