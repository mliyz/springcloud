package com.liyz.common.util.exception;

/**
 * 基础异常类
 *
 * Package : com.yixin.common.exception
 *
 * @author YixinCapital -- wujt 2016年9月20日 上午9:38:31
 *
 */
public class BzException extends RuntimeException {

	/**
	 *
	 * @author YixinCapital -- wujt 2016年9月30日 下午1:37:30
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BzException() {
	}

	public BzException(String message) {
		super(message);
	}

	public BzException(Throwable cause) {
		super(cause);
	}

	public BzException(String message, Throwable cause) {
		super(message, cause);
	}
}
