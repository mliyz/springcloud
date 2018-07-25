package com.liyz.common.util;

/**
 * Created by chenhw on 2016/3/16.
 */

import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BeanUtils
{

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BeanUtils.class);
	private final Object bean;
	private final BeanClassUtils beanClassUtils;

	public BeanUtils(Object bean) {
		Assert.notNull(bean);
		this.bean = bean;
		this.beanClassUtils = new BeanClassUtils(bean.getClass());
	}

	public Map<String, Class<?>> getPropTypes() {
		return this.beanClassUtils.getPropTypes();
	}

	public Map<String, Object> getPropValues() {
		return getPropValues(getReadablePropNames());
	}

	public Map<String, Object> getPropValuesExclude(String[] excludePropNames) {
		return getPropValues(this.beanClassUtils.getReadablePropNamesExclude(excludePropNames));
	}

	public Map<String, Object> getPropValuesExclude(
			Class<? extends Annotation>[] excludeAnnotations) {
		return getPropValues(this.beanClassUtils.getReadablePropNamesExclude(excludeAnnotations));
	}

	private Map<String, Object> getPropValues(Set<String> propNames) {
		Map results = new HashMap();
		Map props = this.beanClassUtils.getPropertyDescriptors();
		try {
			for (String propName : propNames) {
				PropertyDescriptor propertyDescriptor = (PropertyDescriptor) props.get(propName);
				Method readMethod = propertyDescriptor.getReadMethod();
				if (readMethod == null) {
					continue;
				}
				Object value = readMethod.invoke(this.bean, new Object[0]);
				results.put(propName, value);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return results;
	}

	public Set<String> getPropNames() {
		return this.beanClassUtils.getPropNames();
	}

	public Set<String> getReadablePropNames() {
		return this.beanClassUtils.getReadablePropNames();
	}

	public Set<String> getWritablePropNames() {
		return this.beanClassUtils.getWritablePropNames();
	}

	public Object getPropValue(String propName) {
		return getPropValues().get(propName);
	}

	public void setPropValue(String key, Object value) {
		for (Map.Entry entry : this.beanClassUtils.getPropertyDescriptors().entrySet()) {
			if (!((String) entry.getKey()).equals(key)) {
				continue;
			}
			PropertyDescriptor propertyDescriptor = (PropertyDescriptor) entry.getValue();
			Method writeMethod = propertyDescriptor.getWriteMethod();
			if (writeMethod == null)
				continue;
			try {
				writeMethod.invoke(this.bean, new Object[] { value });
			} catch (IllegalAccessException ex) {
				Logger.getLogger(BeanUtils.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IllegalArgumentException ex) {
				Logger.getLogger(BeanUtils.class.getName()).log(Level.SEVERE, null, ex);
			} catch (InvocationTargetException ex) {
				Logger.getLogger(BeanUtils.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void populate(Map<String, ? extends Object> properties) {
		for (Map.Entry entry : properties.entrySet())
			setPropValue((String) entry.getKey(), entry.getValue());
	}

	public void copyPropertiesFrom(Object otherBean) {
		copyProperties(otherBean, this.bean, new String[0]);
	}

	public void copyPropertiesTo(Object otherBean) {
		copyProperties(this.bean, otherBean, new String[0]);
	}

	private static void copyProperties(Object fromBean, Object toBean, String[] excludeProps) {
		BeanUtils from = new BeanUtils(fromBean);
		BeanUtils to = new BeanUtils(toBean);
		Map values = from.getPropValues();
		Set<String> propsToCopy = to.getWritablePropNames();
		if (excludeProps != null) {
			propsToCopy.removeAll(Arrays.asList(excludeProps));
		}
		for (String prop : propsToCopy)
			if (values.containsKey(prop))
				to.setPropValue(prop, values.get(prop));
	}

	public void copyPropertiesFrom(Object otherBean, String[] excludeProps) {
		copyProperties(otherBean, this.bean, excludeProps);
	}

	public void copyPropertiesTo(Object otherBean, String[] excludeProps) {
		copyProperties(this.bean, otherBean, excludeProps);
	}
}
