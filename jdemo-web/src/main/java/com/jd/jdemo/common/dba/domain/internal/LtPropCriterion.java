package com.jd.jdemo.common.dba.domain.internal;

public class LtPropCriterion extends PropertyCompareCriterion {
    public LtPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" < ");
    }
}