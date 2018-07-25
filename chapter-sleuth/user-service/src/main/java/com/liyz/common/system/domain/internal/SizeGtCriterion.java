package com.liyz.common.system.domain.internal;

public class SizeGtCriterion extends SizeCompareCriterion
{
    public SizeGtCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" > ");
    }
}