package com.jd.jdemo.common.dba.domain.internal;

public class SizeNotEqCriterion extends SizeCompareCriterion {
    public SizeNotEqCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" != ");
    }
}