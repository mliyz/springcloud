package com.liyz.common.system.domain.internal;

public class SizeLtCriterion extends SizeCompareCriterion
{
    public SizeLtCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" < ");
    }
}