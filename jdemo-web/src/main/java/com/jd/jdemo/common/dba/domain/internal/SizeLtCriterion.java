package com.jd.jdemo.common.dba.domain.internal;

public class SizeLtCriterion extends SizeCompareCriterion {
    public SizeLtCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" < ");
    }
}