package com.jd.jdemo.common.dba.domain.internal;

public class SizeGeCriterion extends SizeCompareCriterion {
    public SizeGeCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" >= ");
    }
}