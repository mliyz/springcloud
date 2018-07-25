package com.liyz.common.system.domain.internal;

public class SizeNotEqCriterion extends SizeCompareCriterion
{
    public SizeNotEqCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" != ");
    }
}