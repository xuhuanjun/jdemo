package com.jd.jdemo.common.dba.domain.internal;

import com.jd.jdemo.common.dba.domain.NamedParameters;
import com.jd.jdemo.common.dba.domain.QueryCriterion;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EmptyCriterion extends AbstractCriterion {
    public QueryCriterion and(QueryCriterion criterion) {
        return criterion;
    }

    public QueryCriterion or(QueryCriterion criterion) {
        return criterion;
    }

    public QueryCriterion not() {
        return this;
    }

    public boolean isEmpty() {
        return true;
    }

    public String toQueryString() {
        return "";
    }

    public NamedParameters getParameters() {
        return NamedParameters.create();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        return (other instanceof EmptyCriterion);
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 31).toHashCode();
    }
}