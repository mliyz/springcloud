package com.liyz.common.system.domain.internal;

public class NotEqCriterion extends ValueCompareCriterion
{
    public NotEqCriterion(String propName, Object value) {
        super(propName, value);
        setOperator(" != ");
    }
}