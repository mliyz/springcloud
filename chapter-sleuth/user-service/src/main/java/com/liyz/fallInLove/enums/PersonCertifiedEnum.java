package com.liyz.fallInLove.enums;

/**
 *
 * @ClassName: PersonCertifiedEnum
 * @Description 用户认证信息字段对应关系
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月22日 下午7:40:01
 *
 */
public enum PersonCertifiedEnum {

    UNCERT("PCU","实名认证申请","0","未认证"),
    TOCERT("PCT","实名认证申请","1","待审核"),
    CERTSUCC("PCS","实名认证审批","2","审核通过"),
    CERTFAIL("PCF","实名认证审批","3","已驳回");

    private String typeCode;
    private String typeName;
    private String bussCode;
    private String bussName;

    PersonCertifiedEnum(String typeCode, String typeName, String bussCode, String bussName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.bussCode = bussCode;
        this.bussName = bussName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getBussCode() {
        return bussCode;
    }

    public String getBussName() {
        return bussName;
    }
}
