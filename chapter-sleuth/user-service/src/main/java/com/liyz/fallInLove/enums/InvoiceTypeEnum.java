package com.liyz.fallInLove.enums;

/**
 *
 * @ClassName: InvoiceTypeEnum
 * @Description 发票类型枚举类
 * @author  YixinCapital -- lizhongxin
 * @date  2018年6月5日 上午9:50:44
 *
 */
public enum InvoiceTypeEnum {
	
	// 发票类型 1-增票、2-零售票
	VAT("1","增票"),
	RETAIL("2","零售票");
	
	private InvoiceTypeEnum(String typeCode, String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}
	private String typeCode;
	private String typeName;
	
	public String getTypeCode() {
		return typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	
	public static String getNameBycode(String code) {
		for(InvoiceTypeEnum tmp :InvoiceTypeEnum.values()) {
			if(tmp.getTypeCode().equals(code))
				return tmp.getTypeName();
		}
		return null;
	}
}

