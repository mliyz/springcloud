package com.liyz.common.system.domain.internal;

import com.liyz.common.system.domain.Entity;
import com.liyz.common.system.domain.NamedParameters;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class NotInCriterion extends BasicCriterion
{
    private Collection<? extends Object> value = new ArrayList();

    public NotInCriterion(String propName, Collection<? extends Object> value) {
        super(propName);
        if (value != null)
            this.value = value;
    }

    public NotInCriterion(String propName, Object[] value) {
        super(propName);
        if ((value != null) && (value.length > 0))
            this.value = Arrays.asList(value);
    }

    public Collection<? extends Object> getValue() {
        return this.value;
    }

    public String toQueryString() {
        if ((this.value == null) || (this.value.isEmpty()))
            return "";
        return getPropNameWithAlias() + " not in " + getParamNameWithColon();
    }

    public NamedParameters getParameters() {
        NamedParameters result = NamedParameters.create();
        if (!this.value.isEmpty()) {
            result = result.add(getParamName(), this.value);
        }
        return result;
    }

    private String createInString(Collection<? extends Object> value) {
        Set elements = new HashSet();
        for (Iterator i$ = value.iterator(); i$.hasNext();) {
            Object item = i$.next();
            Object element;
            if ((item instanceof Entity))
                element = ((Entity) item).getId();
            else {
                element = item;
            }
            if (((element instanceof String)) || ((element instanceof Date))) {
                element = "'" + element + "'";
            }
            elements.add(element);
        }
        return StringUtils.join(elements, ", ");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotInCriterion)) {
            return false;
        }
        NotInCriterion that = (NotInCriterion) other;
        return new EqualsBuilder().append(getPropName(), that.getPropName()).append(this.value, that.value).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).append(this.value).toHashCode();
    }

    public String toString() {
        return getPropName() + " not in collection [" + collectionToString(this.value) + "]";
    }

    private String collectionToString(Collection<? extends Object> value) {
        return StringUtils.join(value, ", ");
    }
}