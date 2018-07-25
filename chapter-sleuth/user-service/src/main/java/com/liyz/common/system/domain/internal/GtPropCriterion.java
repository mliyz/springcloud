package com.liyz.common.system.domain.internal;

public class GtPropCriterion extends PropertyCompareCriterion
{
    public GtPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" > ");
    }
}