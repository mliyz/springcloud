package com.liyz.common.util.excel;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author yangysh
 * Excel创建后，提供一个用户自己处理Excel工作簿的接口
 */
public interface ExcelEditHandler {
	void edit(Workbook wb);
}
