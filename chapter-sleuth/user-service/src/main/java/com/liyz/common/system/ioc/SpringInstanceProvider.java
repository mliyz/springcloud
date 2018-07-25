package com.liyz.common.system.ioc;

/**
 * Created by chenhw on 2016/3/16.
 */

import com.yixin.common.exception.IocInstanceNotUniqueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SpringInstanceProvider implements InstanceProvider
{

    protected final static Logger logger = LoggerFactory.getLogger(SpringInstanceProvider.class);

    private ApplicationContext applicationContext;

    public SpringInstanceProvider(String[] locations) {
        this.applicationContext = new ClassPathXmlApplicationContext(locations);
    }

    public SpringInstanceProvider(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public SpringInstanceProvider(Class<?>[] annotatedClasses) {
        this.applicationContext = new AnnotationConfigApplicationContext(annotatedClasses);
    }

    public <T> T getInstance(Class<T> beanType) {
        try {
            return this.applicationContext.getBean(beanType);
        } catch (NoUniqueBeanDefinitionException e) {
            throw new IocInstanceNotUniqueException(e);
        } catch (NoSuchBeanDefinitionException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public <T> T getInstance(Class<T> beanType, String beanName) {
        try {
            return this.applicationContext.getBean(beanName, beanType);
        } catch (NoUniqueBeanDefinitionException e) {
            throw new IocInstanceNotUniqueException(e);
        } catch (NoSuchBeanDefinitionException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public <T> T getInstance(Class<T> beanType, Class<? extends Annotation> annotationType) {
        if (annotationType == null) {
            return getInstance(beanType);
        }
        Map<String, T> results = this.applicationContext.getBeansOfType(beanType);
        List resultsWithAnnotation = new ArrayList();
        for (Map.Entry<String, T> entry : results.entrySet()) {
            if (this.applicationContext.findAnnotationOnBean((String) entry.getKey(), annotationType) != null) {
                resultsWithAnnotation.add(entry.getValue());
            }
        }
        if (resultsWithAnnotation.isEmpty()) {
            return null;
        }
        if (resultsWithAnnotation.size() == 1) {
            return (T) resultsWithAnnotation.get(0);
        }
        throw new IocInstanceNotUniqueException();
    }

    public <T> T getByBeanName(String beanName) {
        return (T) this.applicationContext.getBean(beanName);
    }
}
