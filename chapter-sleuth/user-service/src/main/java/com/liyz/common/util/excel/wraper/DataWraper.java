package com.liyz.common.util.excel.wraper;

/*
 * Excel导出的数据容器，接口，策略模式，使用其实现的类获得数据
 * */
public interface DataWraper{
	//

	/**
	 * 下一条数据的判断，如果有,可使用getData()方法获得数据
	 * @return 是否有下一条，
	 */
	boolean next();
	/**
	 * 获得当前行数据
	 * @return
	 */
	Object getRowData();

	/**
	 * 访问完数据后，执行清理，如JDBC关闭结果集和连接
	 */
	void cleanUp();

	/**
	 * 获得当前行数据的字段值
	 * @return
	 */
	Object getFieldValue(String fieldName);
}
