package com.liyz.common.util.excel;


import com.liyz.common.util.excel.formatter.DateTimeValueFormatter;
import com.liyz.common.util.excel.formatter.DefaultNotNullValueFormatter;
import com.liyz.common.util.excel.formatter.ShortDateValueFormatter;
import com.liyz.common.util.excel.formatter.ValueFormatter;
import com.liyz.common.util.excel.formatter.impl.IntegerValueFormatterImpl;

/**
 * @author yangysh
 * 默认提供的格式化器注册表，通过此类获得格式化器，用户自行实现的formatter不通过此类获得
 */
public final class FormatterRegistry {
	private FormatterRegistry() {
	    throw new IllegalAccessError("Utility class");
	  }

	public static ValueFormatter datetimeFormater(){
		return DateTimeValueFormatter.getInstance();
	}
	
	public static ValueFormatter defaultFormater(){
		return DefaultNotNullValueFormatter.getInstance();
	}
	
	public static ValueFormatter shortDateFormater(){
		return ShortDateValueFormatter.getInstance();
	}
	public static ValueFormatter integerValueFormatter(){
		return IntegerValueFormatterImpl.getInstance();
	}
}
