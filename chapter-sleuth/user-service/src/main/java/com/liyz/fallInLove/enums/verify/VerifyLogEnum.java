package com.liyz.fallInLove.enums.verify;
/**
 *
 * @ClassName: VerifyLogEnum
 * @Description 认证审核状态枚举
 * @author  YixinCapital -- lizhongxin
 * @date  2018年5月29日 下午5:21:09
 *
 */
public enum VerifyLogEnum {
	/**
	 * 审核状态 0-未审核、1-审核通过，2-已驳回
	 */
	PERSON_PENDING("0","未审核","VFP","实名认证申请"),
	PERSON_PASS("1","审核通过","VFP","实名认证审批"),
	PERSON_TURN_DOWN("2","已驳回","VFP","实名认证审批"),
	ENTERPRISE_PENDING("0","未审核","VFE","企业认证申请"),
	ENTERPRISE_PASS("1","审核通过","VFE","企业认证审批"),
	ENTERPRISE_TURN_DOWN("2","已驳回","VFE","企业认证审批");

	VerifyLogEnum(String code, String desc,String logTypeCode,String actionName) {
		this.code = code;
		this.desc = desc;
		this.logTypeCode = logTypeCode;
		this.actionName = actionName;
	}

	private String code;
	private String desc;
	private String logTypeCode;
	private String actionName;

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
		for(VerifyLogEnum value : VerifyLogEnum.values()) {
			if(value.getCode().equals(code)) {
				return value.getDesc();
			}
		}
		return null;
	}
	/**
	 *
	 * @Description:根据业务审核code 与类别type 获取日志枚举
	 * @param code
	 * @param type
	 * @return VerifyLogEnum
	 * @throws
	 * @author YixinCapital -- lizhongxin
	 *	       2018年5月31日 上午10:02:07
	 */
	public static VerifyLogEnum getLogEnumByCodeAndType(String code, String type) {
		for(VerifyLogEnum value : VerifyLogEnum.values()) {
			if(value.getCode().equals(code) && value.getLogTypeCode().equals(type)) {
				return value;
			}
		}
		return null;
	}
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    public String getLogTypeCode() {
        return logTypeCode;
    }
    public String getActionName() {
        return actionName;
    }
}

