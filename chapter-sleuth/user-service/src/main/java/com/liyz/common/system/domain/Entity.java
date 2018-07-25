package com.liyz.common.system.domain;

import java.io.Serializable;

/**
 * Created by chenhw on 2016/3/11.
 */
public abstract interface Entity extends Serializable {
    public abstract Serializable getId();

    public abstract boolean existed();

    public abstract boolean notExisted();
}
