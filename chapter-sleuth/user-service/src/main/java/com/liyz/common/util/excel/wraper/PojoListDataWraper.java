package com.liyz.common.util.excel.wraper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/*
 * Excel的数据包装器实现，此类实现最简单的pojo/javaben的列表包装，可以用作vo，dto，jpa实体bean的包装
 * */

public class PojoListDataWraper implements DataWraper {
	private static final Logger logger = LoggerFactory.getLogger(PojoListDataWraper.class);
	private List<Object> dataList = null;
	private Iterator<Object> iter;
	@SuppressWarnings("unused")
	private int idx = 0;
	private Object rowData;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PojoListDataWraper(List list){
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
		return invokeGetMethod(rowData,fieldName);
	}
	@Override
	public void cleanUp() {
		if(dataList != null){
			dataList.clear();
			dataList = null;
		}
	}



	private  Object invokeGetMethod(Object owner, String fieldName){
        Class<? extends Object> ownerClass = owner.getClass();

        //fieldName -> FieldName
        String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);

        Method method = null;
        try{
            method = ownerClass.getMethod("get" + methodName);
        }
        catch (SecurityException | NoSuchMethodException  e){
        	logger.error(e.getMessage(), e);
        	return "";
        }

        //invoke getMethod
        try{
        	if(method != null){
        		return method.invoke(owner);
        	}
            return "";
        }catch (Exception e){
        	logger.error(e.getMessage(), e);
            return "";
        }
    }
	@Override
	public Object getRowData() {
		return rowData;
	}


}
