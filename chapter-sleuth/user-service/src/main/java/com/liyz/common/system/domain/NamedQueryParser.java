package com.liyz.common.system.domain;

import javax.persistence.EntityManager;

/**
 * Created by chenhw on 2016/3/16.
 */
public abstract class NamedQueryParser {
    private EntityManagerProvider entityManagerProvider;

    public NamedQueryParser() {
    }

    public NamedQueryParser(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public void setEntityManagerProvider(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    protected EntityManager getEntityManager() {
        return this.entityManagerProvider.getEntityManager();
    }

    public abstract String getQueryStringOfNamedQuery(String paramString);
}
