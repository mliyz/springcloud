package com.liyz.common.system.ioc;

import java.lang.annotation.Annotation;

/**
 * Created by chenhw on 2016/3/16.
 */
public abstract interface InstanceProvider {
    public abstract <T> T getInstance(Class<T> paramClass);

    public abstract <T> T getInstance(Class<T> paramClass, String paramString);

    public abstract <T> T getInstance(Class<T> paramClass, Class<? extends Annotation> paramClass1);
}
