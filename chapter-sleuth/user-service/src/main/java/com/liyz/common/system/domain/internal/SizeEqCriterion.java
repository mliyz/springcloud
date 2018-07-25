package com.liyz.common.system.domain.internal;

public class SizeEqCriterion extends SizeCompareCriterion
{
    public SizeEqCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" = ");
    }
}