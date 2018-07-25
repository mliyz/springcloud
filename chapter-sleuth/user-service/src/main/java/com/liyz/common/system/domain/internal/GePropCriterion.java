package com.liyz.common.system.domain.internal;

public class GePropCriterion extends PropertyCompareCriterion
{
    public GePropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" >= ");
    }
}