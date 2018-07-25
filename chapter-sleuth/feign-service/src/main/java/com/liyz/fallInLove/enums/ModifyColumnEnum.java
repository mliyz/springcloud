package com.liyz.fallInLove.enums;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @ClassName: ModifyColumnEnum
 * @Description 修改用户资料时候的修改字段对应关系
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月22日 下午2:58:37
 *
 */
public enum ModifyColumnEnum {

    HEADIMG("hi","headImage","修改头像图片"),
    PHONE("ph","phone","修改注册手机号"),
    COMPANYNAME("cn","companyName","修改公司名称"),
    REALNAME("rn","realName","修改真实姓名"),
    WORKPLACE("wp","workingPlace","修改公司地点"),
    TRADEIDENT("ti","tradingIdentities","修改贸易身份"),
    CONTACTPHONE("cp","contactPhone","修改联系电话"),
    QQ("qq","qq","修改QQ"),
    WECHAT("wc","wechat","修改微信"),
    INTRODUCTION("tr","introduction","修改个人简介"),
    CITYNAME("cm","cityName","修改所在城市"),
    CITYCODE("cd","cityCode","修改所在城市"),
    
    IDFRONTIMG("bu","businesscardImage","工作名片照片不能为空"),
    BUSSCARDIMG("fi","idcardFrontImage","身份证正面照片存储路径"),
    IDBACKIMG("bi","idcardBackImage","身份证反面照片存储路径");

    private String moType;
    private String columnName;
    private String columnDesc;

    ModifyColumnEnum(String moType, String columnName,String columnDesc) {
        this.moType = moType;
        this.columnName = columnName;
        this.columnDesc = columnDesc;
    }

    /**
     *
     * @Description: 根据类型获取enum
     * @param moType
     * @return BaUserEnum
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月22日 下午3:03:49
     */
    public static ModifyColumnEnum getColumnEnum(String moType){
        if(StringUtils.isBlank(moType)){
            return null;
        }
        ModifyColumnEnum[] userEnum = ModifyColumnEnum.values();
        for (ModifyColumnEnum temp : userEnum) {
            if(moType.contains(temp.moType)){
                return temp;
            }
        }
        return null;
    }

    /**
     *
     * @Description: 根据类型获取描述信息
     * @param moType
     * @return String
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月22日 下午3:04:25
     */
    public static String getColumnDesc(String moType){
        if(StringUtils.isBlank(moType)){
            return null;
        }
        ModifyColumnEnum[] userEnum = ModifyColumnEnum.values();
        for (ModifyColumnEnum temp : userEnum) {
            if(moType.equals(temp.getMoType())){
                return temp.getColumnDesc();
            }
        }
        return null;
    }
    
    /**
     *
     * @Description: 根据moType获取属性名
     * @param moType
     * @return String
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月22日 下午3:32:24
     */
    public static String getColumnName(String moType){
        if(StringUtils.isBlank(moType)){
            return null;
        }
        ModifyColumnEnum[] userEnum = ModifyColumnEnum.values();
        for (ModifyColumnEnum temp : userEnum) {
            if(moType.equals(temp.getMoType())){
                return temp.getColumnName();
            }
        }
        return null;
    }

    public String getMoType() {
        return moType;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnDesc() {
        return columnDesc;
    }
}
