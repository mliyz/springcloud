package com.liyz.common.system.domain.internal;

import com.liyz.common.system.domain.NamedParameters;
import com.yixin.common.utils.BeanUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;

import java.util.Map;

public abstract class ValueCompareCriterion extends BasicCriterion
{
    protected final Object value;
    private String operator;

    public ValueCompareCriterion(String propName, Object value) {
        super(propName);
        Assert.notNull(value, "Value is null!");
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    protected final void setOperator(String operator) {
        this.operator = operator;
    }

    public String toQueryString() {
        return getPropNameWithAlias() + this.operator + getParamNameWithColon();
    }

    public NamedParameters getParameters() {
        return NamedParameters.create().add(getParamName(), this.value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!getClass().isAssignableFrom(other.getClass())) {
            return false;
        }
        Map thisPropValues = new BeanUtils(this).getPropValues();
        Map otherPropValues = new BeanUtils(other).getPropValues();
        return new EqualsBuilder().append(thisPropValues.get("propName"), otherPropValues.get("propName"))
                .append(thisPropValues.get("value"), otherPropValues.get("value")).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).append(getValue()).toHashCode();
    }

    public String toString() {
        return getPropName() + this.operator + this.value;
    }
}