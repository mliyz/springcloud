package com.liyz.common.system.domain;

import java.util.List;

/**
 * Created by chenhw on 2016/3/16.
 */
public class JpqlQuery extends BaseQuery<JpqlQuery>
{
    private final String jpql;

    public JpqlQuery(EntityRepository repository, String jpql) {
        super(repository);
        this.jpql = jpql;
    }

    public String getJpql() {
        return this.jpql;
    }

    public <T> List<T> list() {
        return getRepository().find(this);
    }

    public <T> T singleResult() {
        return getRepository().getSingleResult(this);
    }

    public int executeUpdate() {
        return getRepository().executeUpdate(this);
    }
}