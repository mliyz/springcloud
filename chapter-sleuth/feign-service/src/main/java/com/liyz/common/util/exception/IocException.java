package com.liyz.common.util.exception;

/**
 * IOC容器异常
 *
 * Created by chenhw on 2016/3/16.
 */
public class IocException extends RuntimeException {
    private static final long serialVersionUID = -2359843215972162510L;

    public IocException() {
    }

    public IocException(String message) {
        super(message);
    }

    public IocException(Throwable cause) {
        super(cause);
    }

    public IocException(String message, Throwable cause) {
        super(message, cause);
    }
}
