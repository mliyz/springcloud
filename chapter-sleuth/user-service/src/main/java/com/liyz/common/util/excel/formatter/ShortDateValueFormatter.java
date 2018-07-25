package com.liyz.common.util.excel.formatter;


import java.text.SimpleDateFormat;

/*
 * 短日期格式化的实现，实现将java.util.Date类型格式化为yyyy-MM-dd的格式
 */

public final class ShortDateValueFormatter implements ValueFormatter{
	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//日期格式
	/**
	 * 私有构造，实现单例
	 */
	private ShortDateValueFormatter(){}
	
	public static ShortDateValueFormatter getInstance() {
        return Nested.instance;
    }
	
	static class Nested{
        private static ShortDateValueFormatter instance = new ShortDateValueFormatter();
    }
	
	@Override
	public String format(Object oriValue,Object rowData) {
		if(oriValue == null){
			return null;
		}
		
		if(!(oriValue instanceof java.util.Date)){
			return "";
		}
		java.util.Date d = (java.util.Date)oriValue;
		return sdf.format(d);
	}
}
