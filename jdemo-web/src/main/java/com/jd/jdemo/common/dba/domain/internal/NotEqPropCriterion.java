package com.jd.jdemo.common.dba.domain.internal;

public class NotEqPropCriterion extends PropertyCompareCriterion {
    public NotEqPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" != ");
    }
}