package com.jd.jdemo.common.dba.domain.internal;

public class LeCriterion extends ValueCompareCriterion {
    public LeCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" <= ");
    }
}