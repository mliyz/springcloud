package com.liyz.common.system.domain.internal;

public class LtCriterion extends ValueCompareCriterion
{
    public LtCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" < ");
    }
}