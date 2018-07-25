package com.liyz.fallInLove.enums.order;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @ClassName: DeliveryModeEnum
 * @Description 订单交货方式
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月31日 上午10:45:08
 *
 */
public enum DeliveryModeEnum {

    SEND("1","送货上门","订单交货方式"),
    SELF("2","当地4S店自提","订单交货方式"),
    LOGISTICAL("3","买方物流","订单交货方式");

    private String modeCode;
    private String modeName;
    private String modeDesc;

    DeliveryModeEnum(String modeCode, String modeName,String modeDesc) {
        this.modeCode = modeCode;
        this.modeName = modeName;
        this.modeDesc = modeDesc;
    }

    /**
     *
     * @Description: 根据code获取enum
     * @param modeCode
     * @return DeliveryModeEnum
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月31日 上午10:48:41
     */
    public static DeliveryModeEnum getDeliveryModeEnum(String modeCode){
        if(StringUtils.isBlank(modeCode)){
            return null;
        }
        DeliveryModeEnum[] deliveryModeEnum = DeliveryModeEnum.values();
        for (DeliveryModeEnum temp : deliveryModeEnum) {
            if(modeCode.contains(temp.modeCode)){
                return temp;
            }
        }
        return null;
    }

    /**
     *
     * @Description: 根据code获取中文名
     * @param modeCode
     * @return String
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月31日 上午10:49:57
     */
    public static String getModeName(String modeCode){
        if(StringUtils.isBlank(modeCode)){
            return null;
        }
        DeliveryModeEnum[] deliveryModeEnum = DeliveryModeEnum.values();
        for (DeliveryModeEnum temp : deliveryModeEnum) {
            if(modeCode.contains(temp.modeCode)){
                return temp.getModeName();
            }
        }
        return null;
    }

    public String getModeCode() {
        return modeCode;
    }

    public String getModeName() {
        return modeName;
    }

    public String getModeDesc() {
        return modeDesc;
    }
}
