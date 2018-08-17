package com.jd.jdemo.common.dba.domain.internal;

import com.jd.jdemo.common.dba.domain.NamedParameters;
import com.jd.jdemo.common.dba.domain.QueryCriterion;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;

public class NotCriterion extends AbstractCriterion {
    private final QueryCriterion criterion;

    public NotCriterion(QueryCriterion criterion) {
        Assert.notNull(criterion, "Query criterion is null!");
        this.criterion = criterion;
    }

    public QueryCriterion getCriteron() {
        return this.criterion;
    }

    public String toQueryString() {
        return "not (" + this.criterion.toQueryString() + ")";
    }

    public NamedParameters getParameters() {
        return this.criterion.getParameters();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotCriterion)) {
            return false;
        }
        NotCriterion that = (NotCriterion) other;
        return new EqualsBuilder().append(getCriteron(), that.getCriteron()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCriteron()).toHashCode();
    }
}