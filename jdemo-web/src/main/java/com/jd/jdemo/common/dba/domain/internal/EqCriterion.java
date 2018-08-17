package com.jd.jdemo.common.dba.domain.internal;

public class EqCriterion extends ValueCompareCriterion {
    public EqCriterion(String propName, Object value) {
        super(propName, value);
        setOperator(" = ");
    }
}