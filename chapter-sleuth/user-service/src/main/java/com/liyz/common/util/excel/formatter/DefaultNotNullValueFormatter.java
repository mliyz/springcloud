package com.liyz.common.util.excel.formatter;

/*
 * 默认格式化的实现，直接使用toString()方式格式化值；值如果为null，则返回空串
 */

public final class DefaultNotNullValueFormatter implements ValueFormatter{
	
	/**
	 * 私有构造，实现单例
	 */
	private DefaultNotNullValueFormatter(){}
	
	public static DefaultNotNullValueFormatter getInstance() {
        return Nested.instance;
    }
	
	static class Nested{
        private static DefaultNotNullValueFormatter instance = new DefaultNotNullValueFormatter();
    }
	
	@Override
	public String format(Object oriValue,Object rowData) {
		if(oriValue == null){
			return "";
		}else{
			return oriValue.toString();
		}
	
	}
}
