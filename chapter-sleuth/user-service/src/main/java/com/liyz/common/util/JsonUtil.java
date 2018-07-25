/**
 * Copyright © 2018 Yixin Info. Tech Ltd. All rights reserved.
 * @Title: JsonUtil.java
 * @Package com.yixin.vehiclemart.util
 * @author mjj
 * @date 2018年5月17日 下午2:35:14
 * @version V1.0
 */
package com.liyz.common.util;

/**
 * @ClassName: JsonUtil
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author  YixinCapital -- mjj
 * @date  2018年5月17日 下午2:35:14
 *
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonNull;

public class JsonUtil {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();

    /**
     * @MethodName : toJson
     * @Description : 将对象转为JSON串，此方法能够满足大部分需求
     * @param src
     *            :将要被转化的对象
     * @return :转化后的JSON串
     */
    public static String toJson(Object src) {
        if (src == null) {
            return gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(src);
    }
}
