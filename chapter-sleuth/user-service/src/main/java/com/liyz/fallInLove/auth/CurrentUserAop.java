package com.liyz.fallInLove.auth;

/**
 * @author YixinCapital -- ${user}
 *         ${date} ${time}
 */

import com.yixin.common.utils.BaseDTO;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 当前用户AOP
 *
 * Package ：com.yixin.quartz.auth
 *
 * @author YixinCapital--wujt 2017/6/28 16:43
 *
 */
public class CurrentUserAop implements MethodBeforeAdvice {

	private void setCurrentUser(Object object) {
		((BaseDTO) object).setCurrentUser(CurrentUser.getCurrentUserDTO());
	}

	private static Method getGetterMethod(Object object, Field field)
			throws NoSuchMethodException, SecurityException {
		return object.getClass().getMethod("get" + toUpperCaseFirstOne(field.getName()));
	}

	private static String toUpperCaseFirstOne(String name) {
		char[] ch = name.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (i == 0) {
				ch[0] = Character.toUpperCase(ch[0]);
			}
		}
		StringBuilder a = new StringBuilder();
		a.append(ch);
		return a.toString();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if (null != CurrentUser.getCurrentUserDTO()) {
			for (Object object : args) {
				if (object instanceof BaseDTO) {
					setCurrentUser(object);
					for (Field field : object.getClass().getDeclaredFields()) {
						if (field.getType().isAssignableFrom(BaseDTO.class)) {
							@SuppressWarnings("cast")
							Object value = (Object) (getGetterMethod(object, field).invoke(object));
							setCurrentUser(value);
						} else if (field.getType().isAssignableFrom(List.class)) {
							@SuppressWarnings("cast")
							Object value = (Object) (getGetterMethod(object, field).invoke(object));
							@SuppressWarnings("unchecked")
							List<Object> dtos = (List<Object>) value;
							if (null != dtos) {
								for (Object dto : dtos) {
									if (dto instanceof BaseDTO) {
										setCurrentUser(dto);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}