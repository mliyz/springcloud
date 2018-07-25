package com.liyz.common.system.domain.internal;

public class NotEqPropCriterion extends PropertyCompareCriterion
{
    public NotEqPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" != ");
    }
}