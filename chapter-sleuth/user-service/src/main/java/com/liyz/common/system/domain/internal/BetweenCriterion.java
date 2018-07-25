package com.liyz.common.system.domain.internal;

import com.liyz.common.system.domain.NamedParameters;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;

public class BetweenCriterion extends BasicCriterion
{
	private final Comparable<?> from;
	private final Comparable<?> to;

	public BetweenCriterion(String propName, Comparable<?> from, Comparable<?> to) {
		super(propName);
		Assert.notNull(from, "From value is null!");
		Assert.notNull(to, "To value is null!");
		this.from = from;
		this.to = to;
	}

	public Comparable<?> getFrom() {
		return this.from;
	}

	public Comparable<?> getTo() {
		return this.to;
	}

	public String toQueryString() {
		return String.format("%s between %s and %s", getPropNameWithAlias(),
				getParamNameWithColon() + "_from", getParamNameWithColon() + "_to");
	}

	public NamedParameters getParameters() {
		return NamedParameters.create().add(getParamName() + "_from", this.from)
				.add(getParamName() + "_to", this.to);
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BetweenCriterion)) {
			return false;
		}
		BetweenCriterion that = (BetweenCriterion) other;
		return new EqualsBuilder().append(getPropName(), that.getPropName())
				.append(getFrom(), that.getFrom()).append(getTo(), that.getTo()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getPropName()).append(this.from).append(this.to)
				.toHashCode();
	}

	public String toString() {
		return getPropName() + " between " + this.from + " and " + this.to;
	}
}