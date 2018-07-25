package com.liyz.common.system.domain.internal;

public class LtPropCriterion extends PropertyCompareCriterion
{
    public LtPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" < ");
    }
}