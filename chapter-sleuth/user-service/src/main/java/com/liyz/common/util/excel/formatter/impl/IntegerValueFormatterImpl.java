package com.liyz.common.util.excel.formatter.impl;


import com.liyz.common.util.excel.formatter.ValueFormatter;

public final class IntegerValueFormatterImpl implements ValueFormatter
{
	/**
	 * 私有构造，实现单例
	 */
	private IntegerValueFormatterImpl(){}

	public static IntegerValueFormatterImpl getInstance() {
        return Nested.instance;
    }

	static class Nested{
        private static IntegerValueFormatterImpl instance = new IntegerValueFormatterImpl();
    }

	@Override
	public Integer format(Object oriValue, Object rowData) {
		if(oriValue == null){
			return null;
		}

		return (Integer) oriValue;
	}

}
