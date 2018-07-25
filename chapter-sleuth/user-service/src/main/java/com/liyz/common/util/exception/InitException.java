package com.liyz.common.util.exception;

/**
 * 初始化异常
 *
 * Package : com.yixin.common.exception
 *
 * @author YixinCapital -- wujt
 *		   2016年7月12日 上午10:48:02
 *
 */
public class InitException extends Throwable {

    private static final long serialVersionUID = -581984046035303044L;

    public InitException() {
        super();
    }

    public InitException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitException(String message) {
        super(message);
    }

    public InitException(Throwable cause) {
        super(cause);
    }

}
