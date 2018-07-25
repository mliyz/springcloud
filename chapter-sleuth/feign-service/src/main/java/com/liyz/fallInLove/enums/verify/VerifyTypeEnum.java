package com.liyz.fallInLove.enums.verify;
/**
 *
 * @ClassName: VerifyTypeEnum
 * @Description 认证类型枚举
 * @author  YixinCapital -- lizhongxin
 * @date  2018年5月29日 下午8:40:18
 *
 */
public enum VerifyTypeEnum {
	//认证类型: 1-实名认证，2-企业认证
	REALNAME_AUTHENTICATION("1","实名认证"),
	ENTERPRISE_AUTHENTICATION("2","企业认证");


	private String typeCode;
	private String typeName;

	VerifyTypeEnum(String code,String name){
		this.typeCode = code;
		this.typeName =name;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public String getTypeName() {
		return typeName;
	}


}

