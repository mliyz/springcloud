package com.liyz.common.system.domain.internal;

public class LeCriterion extends ValueCompareCriterion
{
    public LeCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" <= ");
    }
}