package com.liyz.common.util;

import com.yixin.common.utils.InvokeResult;

/**
 * 返回结果工具类
 * Package : com.yixin.vehiclemart.util
 *
 */
public class ResultUtil {
	/**
	 * 处理成功返回
	 *
	 * @param object
	 * @return InvokeResult
	 */
	public static InvokeResult success(Object object) {
		InvokeResult result = new InvokeResult();
        result.setData(object);
        return result;
    }
	/**
	 * 处理成功返回
	 * @return InvokeResult
	 */
    public static InvokeResult success() {
        return success(null);
    }
    /**
     * 处理失败返回
     * @param errorMessage
     * @return InvokeResult
     */
    public static InvokeResult error(String errorMessage) {
    	InvokeResult result = new InvokeResult();
        result.setHasErrors(true);
        result.setErrorMessage(errorMessage);
        return result;
    }
}

