package com.liyz.common.system.domain.internal;

public class EqPropCriterion extends PropertyCompareCriterion
{
    public EqPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" = ");
    }
}