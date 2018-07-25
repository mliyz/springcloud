package com.liyz.common.util.excel.wraper;


import com.liyz.common.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Iterator;


/*
 * Excel的数据包装器实现，此类实现分页的pojo/javaben的列表包装，可以用作vo，dto，jpa实体bean的包装
 * 抛出抽象方法让客户端实现查找下一页的
 * */


public abstract class YxPagedDataWraper<T> implements DataWraper {
	private static final Logger logger = LoggerFactory.getLogger(YxPagedDataWraper.class);
	private Page<T> pagedData = null;
	//private List<Object> currentList = null;//当前页的数据列表
	private Iterator<T> iter;
	private Object rowData;
	private int pageNo = 1;//当前页号,1 based
	private boolean firstQueryExecuted = false;
	
	private void initialize(){
		if(this.pagedData.getData() != null){
			iter = this.pagedData.getData().iterator();
			this.pageNo = (int)this.pagedData.getCurrent();
		}
	}
	@Override
	public boolean next() {
		if(!firstQueryExecuted){
			this.pagedData = fetchPageData(this.pageNo);
			initialize();
			firstQueryExecuted = true;
		}
		boolean hasNext = iter.hasNext();
		if(hasNext){
			this.rowData = iter.next();
		}else{
			//如果没有数据了，那么让客户端进行分页查询
			if(this.pageNo<this.pagedData.getPageCount()){
				this.pagedData = fetchPageData(this.pageNo+1);
				initialize();
				
				if(hasNext = iter.hasNext()){
					this.rowData = iter.next();
				}
			}
		}
		return hasNext;
	}
	/**
	 * 获取下一个分页对象
	 */
	/**
	 * @param pageIndex zero based pageIndex
	 * @return
	 */
	public abstract Page<T> fetchPageData(int pageNo);
	
	@Override
	public Object getFieldValue(String fieldName){
		return invokeGetMethod(rowData,fieldName);
	}
	@Override
	public void cleanUp() {
		this.pagedData = null;
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
