package com.liyz.common.util.excel.formatter;


//列表中数据值翻译的接口，如数字翻译为汉字，数值的格式化
public interface ValueFormatter<T> {
	/**
	 * @param oriValue 本列的原始值
	 * @param rowData 本行的数据例如map或者pojo对象
	 * @return 格式化后的字符串
	 */
	T format(Object oriValue, Object rowData);
}
