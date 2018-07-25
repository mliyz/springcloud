package com.liyz.common.system.domain.internal;

import com.liyz.common.system.domain.QueryCriterion;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractCriterion implements QueryCriterion
{
    protected String queryString;

    public QueryCriterion and(QueryCriterion criterion) {
        return new AndCriterion(new QueryCriterion[] { this, criterion });
    }

    public QueryCriterion or(QueryCriterion criterion) {
        return new OrCriterion(new QueryCriterion[] { this, criterion });
    }

    public QueryCriterion not() {
        return new NotCriterion(this);
    }

    public boolean isEmpty() {
        return false;
    }

    protected List<QueryCriterion> removeNullOrEmptyCriterion(QueryCriterion[] criterions) {
        List results = new ArrayList();
        for (QueryCriterion each : criterions) {
            if ((each == null) || (each.isEmpty())) {
                continue;
            }
            results.add(each);
        }
        return results;
    }

    public String toQueryString() {
        return this.queryString;
    }

    public abstract boolean equals(Object paramObject);

    public abstract int hashCode();
}