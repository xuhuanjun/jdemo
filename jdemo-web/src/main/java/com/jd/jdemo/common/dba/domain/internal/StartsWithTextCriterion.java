package com.jd.jdemo.common.dba.domain.internal;

import com.jd.jdemo.common.dba.domain.NamedParameters;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class StartsWithTextCriterion extends BasicCriterion {
    private final String value;

    public StartsWithTextCriterion(String propName, String value) {
        super(propName);
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toQueryString() {
        return getPropNameWithAlias() + " like " + getParamNameWithColon();
    }

    public NamedParameters getParameters() {
        return NamedParameters.create().add(getParamName(), this.value + "%");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartsWithTextCriterion)) {
            return false;
        }
        StartsWithTextCriterion that = (StartsWithTextCriterion) other;
        return new EqualsBuilder().append(getPropName(), that.getPropName()).append(this.value, that.value).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).append(this.value).toHashCode();
    }

    public String toString() {
        return getPropName() + " like '" + this.value + "*'";
    }
}