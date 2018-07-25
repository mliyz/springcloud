package com.liyz.fallInLove.enums;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @ClassName: PaymentTypeEnum
 * @Description 付款类型
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月31日 上午10:45:08
 *
 */
public enum PaymentTypeEnum {

    ALLPAY("1","全款发车","付款类型"),
    PARTPAY("2","定金发车","付款类型");

    private String code;
    private String name;
    private String desc;

    PaymentTypeEnum(String code, String name,String desc) {
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
    public static PaymentTypeEnum getEnum(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        PaymentTypeEnum[] enums = PaymentTypeEnum.values();
        for (PaymentTypeEnum temp : enums) {
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
        PaymentTypeEnum[] enums = PaymentTypeEnum.values();
        for (PaymentTypeEnum temp : enums) {
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
