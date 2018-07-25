package com.liyz.common.util.excel;


import org.apache.poi.ss.usermodel.Workbook;

/**
 * 什么都不做的Excel编辑实现类，是默认的实现
 * @author yangys
 *
 */
public class EmptyEditHandler implements ExcelEditHandler {

	@Override
	public void edit(Workbook wb) {
	}
}
