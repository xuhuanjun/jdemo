package com.jd.jdemo.common.dba.domain.internal;

import com.jd.jdemo.common.dba.domain.NamedParameters;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class NotEmptyCriterion extends BasicCriterion {
    public NotEmptyCriterion(String propName) {
        super(propName);
    }

    public String toQueryString() {
        return getPropNameWithAlias() + " is not empty";
    }

    public NamedParameters getParameters() {
        return NamedParameters.create();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotEmptyCriterion)) {
            return false;
        }
        NotEmptyCriterion that = (NotEmptyCriterion) other;
        return new EqualsBuilder().append(getPropName(), that.getPropName()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).toHashCode();
    }

    public String toString() {
        return getPropName() + " is not empty";
    }
}