package com.jd.jdemo.common.dba.domain.internal;

public class GtCriterion extends ValueCompareCriterion {
    public GtCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" > ");
    }
}