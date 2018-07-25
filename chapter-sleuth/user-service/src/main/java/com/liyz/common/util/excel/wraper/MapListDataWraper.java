package com.liyz.common.util.excel.wraper;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * Excel的数据包装器实现，此类实现Map的列表包装,例如使用select new map(xxx)查询的数据
 * */

public class MapListDataWraper implements DataWraper {
	@SuppressWarnings("rawtypes")
	private List<Map> dataList = null;
	@SuppressWarnings("rawtypes")
	private Iterator<Map> iter;
	//private int idx = 0;
	@SuppressWarnings("rawtypes")
	private Map rowData;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapListDataWraper(List list){
		dataList = list;
		if(dataList != null){
			iter = dataList.iterator();
		}
	}

	@Override
	public boolean next() {
		boolean hasNext = iter.hasNext();
		if(hasNext){
			this.rowData = iter.next();
		}
		return hasNext;
	}

	@Override
	public Object getFieldValue(String fieldName){
		return this.rowData.get(fieldName);

	}
	@Override
	public void cleanUp() {
		if(dataList != null){
			dataList.clear();
			dataList = null;
		}
	}

	@Override
	public Object getRowData() {
		return this.rowData;
	}


}
