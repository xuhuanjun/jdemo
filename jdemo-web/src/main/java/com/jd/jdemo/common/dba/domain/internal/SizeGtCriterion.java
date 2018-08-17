package com.jd.jdemo.common.dba.domain.internal;

public class SizeGtCriterion extends SizeCompareCriterion {
    public SizeGtCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" > ");
    }
}