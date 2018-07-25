package com.liyz.common.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lianghaoguan on 2017/10/18.
 */
public class PropertyUtil {

    private static final String SET_PREFIX = "set";
    private static final String GET_PREFIX = "get";

    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {//根据需求，定制 自己的get和set方法
        Method setMethod = null;
        Method getMethod = null;
        PropertyDescriptor pd = null;
        try {
            Field field = clazz.getDeclaredField(propertyName);// 根据字段名来获取字段
            if (field != null) {
                // 构建方法的后缀
                String methodEnd = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                setMethod = clazz.getDeclaredMethod(SET_PREFIX + methodEnd, new Class[] { field.getType() });
                // 构建get 方法
                getMethod = clazz.getDeclaredMethod(GET_PREFIX + methodEnd, new Class[] {});
                // 构建一个属性描述器 把对应属性 propertyName 的 get 和 set 方法保存到属性描述器中
                pd = new PropertyDescriptor(propertyName, getMethod, setMethod);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pd;
    }

    public static PropertyDescriptor getPropertyDescriptor2(Class<?> clazz, String propertyName) {//使用 PropertyDescriptor 提供的 get和set方法
        try {
            return new PropertyDescriptor(propertyName, clazz);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setProperty(Object obj, String propertyName, Object value) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = obj.getClass();// 获取对象的类型
        PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);// 获取
        // clazz
        // 类型中的
        // propertyName
        // 的属性描述器
        Method setMethod = pd.getWriteMethod();// 从属性描述器中获取 set 方法
        // 调用 set方法将传入的value值保存属性中去
        setMethod.invoke(obj, new Object[] { value });
    }

    public static Object getProperty(Object obj, String propertyName) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = obj.getClass();// 获取对象的类型
        PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);// 获取
        // clazz
        // 类型中的
        // propertyName
        // 的属性描述器
        Method getMethod = pd.getReadMethod();// 从属性描述器中获取 get 方法
        Object value = getMethod.invoke(obj, null);// 调用方法获取方法的返回值

        return value;// 返回值
    }
}
