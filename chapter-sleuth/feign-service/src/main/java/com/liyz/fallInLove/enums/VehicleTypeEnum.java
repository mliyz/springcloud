package com.liyz.fallInLove.enums;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @ClassName: VehicleTypeEnum
 * @Description 车辆类型
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月31日 上午10:45:08
 *
 */
public enum VehicleTypeEnum {

    DOMISTICSPOT("1","国产-现车","车辆类型"),
    DOMISTICFUTURES("2","国产-期货","车辆类型"),
    JOINSPOT("3","合资-现车","车辆类型"),
    JOINFUTURES("4","合资-期货","车辆类型"),
    IMPORTSPOT("5","进口-现车","车辆类型"),
    IMPORTFUTURES("6","进口-期货","车辆类型");

    private String code;
    private String name;
    private String desc;

    VehicleTypeEnum(String code, String name,String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    /**
     *
     * @Description: 根据code获取enum
     * @param code
     * @return VehicleTypeEnum
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月31日 上午10:48:41
     */
    public static VehicleTypeEnum getEnum(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        VehicleTypeEnum[] enums = VehicleTypeEnum.values();
        for (VehicleTypeEnum temp : enums) {
            if(code.contains(temp.code)){
                return temp;
            }
        }
        return null;
    }
    
    /**
     *
     * @Description: 根据code获取中文名
     * @param code
     * @return String
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月31日 上午10:49:57
     */
    public static String getName(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        VehicleTypeEnum[] enums = VehicleTypeEnum.values();
        for (VehicleTypeEnum temp : enums) {
            if(code.equals(temp.code)){
                return temp.getName();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
