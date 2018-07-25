package com.liyz.fallInLove.enums;

/**
 *
 * @ClassName: UserInfoLogEnum
 * @Description 用户信息修改字段对应关系
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月22日 下午7:40:01
 *
 */
public enum UserInfoLogEnum {

    CERTFAIL("UIL","修改个人信息","1","修改成功");

    private String typeCode;
    private String typeName;
    private String bussCode;
    private String bussName;

    UserInfoLogEnum(String typeCode, String typeName, String bussCode, String bussName) {
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
