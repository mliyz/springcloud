package com.liyz.common.system.domain.internal;

public class SizeLeCriterion extends SizeCompareCriterion
{
    public SizeLeCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" <= ");
    }
}