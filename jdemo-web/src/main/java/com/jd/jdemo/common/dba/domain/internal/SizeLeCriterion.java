package com.jd.jdemo.common.dba.domain.internal;

public class SizeLeCriterion extends SizeCompareCriterion {
    public SizeLeCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" <= ");
    }
}