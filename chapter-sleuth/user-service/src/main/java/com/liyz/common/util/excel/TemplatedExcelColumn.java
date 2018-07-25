package com.liyz.common.util.excel;


/*
 * 基于模板的Excel导出的列定义，包括列索引，列名和格式化器(ValueFormater)
 */


import com.liyz.common.util.excel.formatter.ValueFormatter;

import java.text.MessageFormat;

class TemplatedExcelColumn {
	private int index;//列索引
	private String fieldName;//列名称，比如jdbc ResultSet的列名，Map保存数据为key的名称;java bean中的属性(getXXX)
	private ValueFormatter valueFormatter;//自定义格式化器，用与字段的翻译/格式化，根据数值翻译为字典表中的文本数据,如日期、时间，钱币等特殊数据的格式化
	
	TemplatedExcelColumn(int index, String fieldName, ValueFormatter valueFormatter) {
		super();
		if(index < 0){
			throw new IllegalArgumentException("类索引必须为>=0的整数，当前索引值为:"+index);
		}
		if(fieldName==null || "".equals(fieldName.trim())){
			throw new IllegalArgumentException("字段名不能为空");
		}
		if(valueFormatter == null){
			throw new IllegalArgumentException("格式化器valueFormater不能为null");
		}
		
		this.index = index;
		this.fieldName = fieldName;
		
		this.valueFormatter = valueFormatter;
	}
	
	TemplatedExcelColumn(int index, String fieldName) {
		this(index,fieldName,FormatterRegistry.defaultFormater());
	}
	
	

	int getIndex() {
		return index;
	}
	void setIndex(int index) {
		this.index = index;
	}
	String getFieldName() {
		return fieldName;
	}


	void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	

	public ValueFormatter getValueFormatter() {
		return valueFormatter;
	}

	public void setValueFormatter(ValueFormatter valueFormatter) {
		this.valueFormatter = valueFormatter;
	}

	public static void main(String[] args){
		int planet = 7;
		 String event = null;

		 String result = MessageFormat.format(
		     "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
		     planet, new java.util.Date(), event);
		 
		 MessageFormat mf = new MessageFormat("{0,number,#.##}, {0,number,#.#}");
		 Object[] objs = {new Double(3.1415)};
		 result = mf.format( objs );
		 System.out.println(result);
	}
}
