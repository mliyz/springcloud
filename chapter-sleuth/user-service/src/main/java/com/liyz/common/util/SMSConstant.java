package com.liyz.common.util;

/**
 * 发送短信公共配置类
 * Package : com.yixin.vehiclemart.util
 *
 * @author yangfei02
 * @date 2018年5月16日 上午10:54:30
 *
 */
public class SMSConstant {

	private SMSConstant() {
	    throw new IllegalAccessError("Utility class");
	  }
	/**
	 * 短信验证码调用基础发短信方法时的通道
	 */
	public static final String VERIFICATION_SMS_CHANNEL = "sms_wxxsxx_yxyw1";
	/**
	 * 注册用短信验证码内容
	 */
	public static final String VERIFICATION_CONTENT = "【易鑫集团】您正在注册易鑫旗下淘开鑫平台，验证码：%s（15分钟内有效）。该验证码用于注册淘开鑫，请勿泄露该验证码。";
	/**
	 * 重置密码用短信验证码内容
	 */
	public static final String VERIFICATION_PASSWORD_RECOVERY_CONTENT = "【易鑫集团】您正在使用易鑫旗下淘开鑫平台，验证码：%s（15分钟内有效）。该验证码用于重置密码，请勿泄露该验证码。";
	/**
	 * 实名认证  certification
	 */
	public static final String VERIFICATION_CERTIFICATION_CONTENT = "【易鑫集团】您正在使用易鑫旗下淘开鑫平台，验证码：%s（15分钟内有效）。该验证码用于实名认证，请勿泄露该验证码。";
}

