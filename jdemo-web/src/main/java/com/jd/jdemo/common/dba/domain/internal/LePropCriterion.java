package com.jd.jdemo.common.dba.domain.internal;

public class LePropCriterion extends PropertyCompareCriterion {
    public LePropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" <= ");
    }
}