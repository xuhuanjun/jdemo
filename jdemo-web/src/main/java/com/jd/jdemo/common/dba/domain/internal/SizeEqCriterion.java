package com.jd.jdemo.common.dba.domain.internal;

public class SizeEqCriterion extends SizeCompareCriterion {
    public SizeEqCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" = ");
    }
}