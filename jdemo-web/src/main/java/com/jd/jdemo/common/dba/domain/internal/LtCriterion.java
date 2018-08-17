package com.jd.jdemo.common.dba.domain.internal;

public class LtCriterion extends ValueCompareCriterion {
    public LtCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" < ");
    }
}