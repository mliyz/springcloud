package com.liyz.fallInLove.enums;

/**
 *
 * @ClassName: EnterpriseCertifiedEnum
 * @Description 企业认证信息字段对应关系
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月22日 下午7:40:01
 *
 */
public enum EnterpriseCertifiedEnum {

    UNCERT("ECU","企业认证申请","0","未认证"),
    TOCERT("ECT","企业认证申请","1","待审核"),
    CERTSUCC("ECS","企业认证审批","2","审核通过"),
    CERTFAIL("ECF","企业认证审批","3","已驳回");

    private String typeCode;
    private String typeName;
    private String bussCode;
    private String bussName;

    EnterpriseCertifiedEnum(String typeCode, String typeName, String bussCode, String bussName) {
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
