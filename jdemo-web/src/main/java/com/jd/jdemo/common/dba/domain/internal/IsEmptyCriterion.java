package com.jd.jdemo.common.dba.domain.internal;

import com.jd.jdemo.common.dba.domain.NamedParameters;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IsEmptyCriterion extends BasicCriterion {
    public IsEmptyCriterion(String propName) {
        super(propName);
    }

    public String toQueryString() {
        return getPropNameWithAlias() + " is empty";
    }

    public NamedParameters getParameters() {
        return NamedParameters.create();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IsEmptyCriterion)) {
            return false;
        }
        IsEmptyCriterion that = (IsEmptyCriterion) other;
        return new EqualsBuilder().append(getPropName(), that.getPropName()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).toHashCode();
    }

    public String toString() {
        return getPropName() + " is empty";
    }
}