package com.liyz.common.system.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenhw on 2016/3/16.
 */
public class PositionalParameters implements QueryParameters
{
    private Object[] params;

    public static PositionalParameters create() {
        return new PositionalParameters(new Object[0]);
    }

    public static PositionalParameters create(Object[] params) {
        return new PositionalParameters(params);
    }

    public static PositionalParameters create(List<Object> params) {
        return new PositionalParameters(params.toArray());
    }

    private PositionalParameters(Object[] params) {
        if (params == null)
            this.params = new Object[0];
        else
            this.params = Arrays.copyOf(params, params.length);
    }

    public Object[] getParams() {
        return Arrays.copyOf(this.params, this.params.length);
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 43).append(this.params).toHashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PositionalParameters)) {
            return false;
        }
        PositionalParameters that = (PositionalParameters) other;
        return new EqualsBuilder().append(getParams(), that.getParams()).isEquals();
    }

    public String toString() {
        return Arrays.toString(this.params);
    }
}