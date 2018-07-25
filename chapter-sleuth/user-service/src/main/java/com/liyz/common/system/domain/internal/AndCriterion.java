package com.liyz.common.system.domain.internal;

import com.liyz.common.system.domain.NamedParameters;
import com.liyz.common.system.domain.QueryCriterion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AndCriterion extends AbstractCriterion
{
    private final List<QueryCriterion> criterions;

    public AndCriterion(QueryCriterion[] criterions) {
        Assert.notNull(criterions, "Criterions to \"AND\" is null!");
        this.criterions = removeNullOrEmptyCriterion(criterions);
        Assert.isTrue(criterions.length > 1, "At least two query criterions required!");
    }

    public List<QueryCriterion> getCriterons() {
        return this.criterions;
    }

    public String toQueryString() {
        List subCriterionsStr = new ArrayList();
        for (QueryCriterion each : getCriterons()) {
            subCriterionsStr.add(each.toQueryString());
        }
        return StringUtils.join(subCriterionsStr, " and ");
    }

    public NamedParameters getParameters() {
        NamedParameters result = NamedParameters.create();
        for (QueryCriterion each : getCriterons()) {
            result.add(each.getParameters());
        }
        return result;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AndCriterion)) {
            return false;
        }
        AndCriterion that = (AndCriterion) other;
        return new EqualsBuilder().append(getCriterons(), that.getCriterons()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCriterons()).toHashCode();
    }
}