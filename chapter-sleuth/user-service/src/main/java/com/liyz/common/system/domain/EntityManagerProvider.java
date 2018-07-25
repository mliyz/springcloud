package com.liyz.common.system.domain;

import com.liyz.common.system.ioc.InstanceFactory;
import com.yixin.common.exception.IocInstanceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by chenhw on 2016/3/16.
 */
public class EntityManagerProvider {
    protected final static Logger logger = LoggerFactory.getLogger(EntityManagerProvider.class);
    private EntityManagerFactory entityManagerFactory;
    private final ThreadLocal<EntityManager> entityManagerHolder = new ThreadLocal<EntityManager>();

    public EntityManagerProvider() {
        this.entityManagerFactory = (InstanceFactory.getInstance(EntityManagerFactory.class));
    }

    public EntityManagerProvider(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManagerProvider(EntityManager entityManager) {
        this.entityManagerHolder.set(entityManager);
    }

    public EntityManager getEntityManager() {
        EntityManager result = this.entityManagerHolder.get();
        if ((result != null) && (result.isOpen())) {
            return result;
        }
        result = getEntityManagerFromIoC();
        this.entityManagerHolder.set(result);
        return result;
    }

    public EntityManager getEntityManagerFromIoC() {
        try {
            return InstanceFactory.getInstance(EntityManager.class);
        } catch (IocInstanceNotFoundException e) {
            logger.error(e.getMessage(), e);
            if (this.entityManagerFactory == null)
                this.entityManagerFactory = InstanceFactory.getInstance(EntityManagerFactory.class);
        }
        return this.entityManagerFactory.createEntityManager();
    }
}
