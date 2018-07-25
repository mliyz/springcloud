package com.liyz.fallInLove.enums.verify;
/**
 *
 * @ClassName: VerifyStatusEnum
 * @Description 认证审核状态枚举
 * @author  YixinCapital -- lizhongxin
 * @date  2018年5月29日 下午5:21:09
 *
 */
public enum VerifyStatusEnum {

	 //审核状态 0-未审核、1-审核通过，2-已驳回
	/**
	 * 0-未审核
	 */
	PENDING("0","未审核"),
	/**
	 * 1-审核通过
	 */
	PASS("1","审核通过"),
	/**
	 * 2-已驳回
	 */
	TURN_DOWN("2","已驳回");

	VerifyStatusEnum(String code, String desc) {
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
	/**
	 *
	 * @Description: 根据状态码返还状态描述
	 * @param code
	 * @return String
	 * @throws
	 * @author YixinCapital -- lizhongxin
	 *	       2018年5月29日 下午5:34:07
	 */
	public static String getStatusDescByCode(String code) {
		for(VerifyStatusEnum value : VerifyStatusEnum.values()) {
			if(value.getCode().equals(code)) {
				return value.getDesc();
			}
		}
		return null;
	}
}

