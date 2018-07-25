package com.liyz.common.util.excel.formatter;


public interface IntegerValueFormatter extends ValueFormatter{
	
	Integer format(Integer oriValue, Object rowData);
	
}
