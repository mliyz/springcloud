package com.liyz.fallInLove.enums;
/**
 *
 * @ClassName: CertifiedResultEnum
 * @Description 认证结果枚举
 * @author  YixinCapital -- liyuzhang
 * @date  2018年6月6日 下午4:41:09
 *
 */
public enum CertifiedResultEnum {
   //认证结果 0-未认证，1-待审核，2-认证成功，3-认证失败
	/**
	 * 0-未认证
	 */
	UNAUTHORIZED("0","未认证"),
	/**
	 * 1-待审核
	 */
	AUDIT("1","待审核"),
	/**
	 * 2-认证成功
	 */
	AUTHENTICATION_OK("2","认证成功"),
	/**
	 * 3-认证失败
	 */
	AUTHENTICATION_FAIL("3","认证失败"),;
	
	CertifiedResultEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	private String code;
	private String desc;
	
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	
	
}
