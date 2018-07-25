package com.liyz.common.system.domain.internal;

public class SizeGeCriterion extends SizeCompareCriterion
{
    public SizeGeCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" >= ");
    }
}