package com.jd.jdemo.common.dba.domain.internal;

public class GtPropCriterion extends PropertyCompareCriterion {
    public GtPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" > ");
    }
}