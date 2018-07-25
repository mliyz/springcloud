package com.liyz.common.system.domain.internal;

public class GeCriterion extends ValueCompareCriterion
{
    public GeCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" >= ");
    }
}