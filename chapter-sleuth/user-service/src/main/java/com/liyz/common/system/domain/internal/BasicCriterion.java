package com.liyz.common.system.domain.internal;

public abstract class BasicCriterion extends AbstractCriterion
{
    private final String propName;

    public BasicCriterion(String propName) {
        this.propName = propName;
    }

    public String getPropName() {
        return this.propName;
    }

    protected String getPropNameWithAlias() {
        return "rootEntity." + this.propName;
    }

    protected String getParamName() {
        String result = "rootEntity_" + this.propName + hashCode();
        result = result.replace(".", "_");
        result = result.replace("-", "_");
        return result;
    }

    protected String getParamNameWithColon() {
        return ":" + getParamName();
    }
}