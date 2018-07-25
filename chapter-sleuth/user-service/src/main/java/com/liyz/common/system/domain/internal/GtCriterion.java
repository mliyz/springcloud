package com.liyz.common.system.domain.internal;

public class GtCriterion extends ValueCompareCriterion
{
    public GtCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" > ");
    }
}