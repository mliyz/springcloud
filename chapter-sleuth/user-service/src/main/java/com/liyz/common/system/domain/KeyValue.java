package com.liyz.common.system.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by chenhw on 2016/3/16.
 */
public class KeyValue<K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(this.key).append(this.value).toHashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyValue)) {
            return false;
        }
        KeyValue that = (KeyValue) other;
        return new EqualsBuilder().append(this.key, that.key).append(this.value, that.value).isEquals();
    }

    public String toString() {
        return "KeyValue [key=" + this.key + ", value=" + this.value + "]";
    }
}
