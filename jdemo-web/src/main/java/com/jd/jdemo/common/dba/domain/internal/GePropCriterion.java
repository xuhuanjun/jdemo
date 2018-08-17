package com.jd.jdemo.common.dba.domain.internal;

public class GePropCriterion extends PropertyCompareCriterion {
    public GePropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" >= ");
    }
}