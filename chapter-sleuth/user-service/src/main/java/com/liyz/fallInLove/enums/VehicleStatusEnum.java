package com.liyz.fallInLove.enums;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @ClassName: VehicleStatusEnum
 * @Description 车辆状态
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月31日 上午10:45:08
 *
 */
public enum VehicleStatusEnum {
    
    TOSEND("1","待发车","车辆状态"),
    TORECEIVE("2","待收车","车辆状态"),
    CONFIRMRECEIVE("3","已确认收车","车辆状态");

    private String code;
    private String name;
    private String desc;

    VehicleStatusEnum(String code, String name,String desc) {
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
    public static VehicleStatusEnum getEnum(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        VehicleStatusEnum[] enums = VehicleStatusEnum.values();
        for (VehicleStatusEnum temp : enums) {
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
        VehicleStatusEnum[] enums = VehicleStatusEnum.values();
        for (VehicleStatusEnum temp : enums) {
            if(code.contains(temp.code)){
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
