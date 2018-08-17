package com.jd.jdemo.common.dba.domain.internal;

public class GeCriterion extends ValueCompareCriterion {
    public GeCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" >= ");
    }
}