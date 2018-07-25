package com.liyz.common.system.domain;

/**
 * Created by chenhw on 2016/3/16.
 */
public abstract interface QueryCriterion {
    public static final String ROOT_ALIAS = "rootEntity";

    public abstract QueryCriterion and(QueryCriterion paramQueryCriterion);

    public abstract QueryCriterion or(QueryCriterion paramQueryCriterion);

    public abstract QueryCriterion not();

    public abstract boolean isEmpty();

    public abstract String toQueryString();

    public abstract NamedParameters getParameters();
}
