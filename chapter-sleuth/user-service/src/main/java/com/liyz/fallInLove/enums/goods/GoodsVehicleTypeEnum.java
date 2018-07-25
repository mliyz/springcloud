package com.liyz.fallInLove.enums.goods;

import org.apache.commons.lang3.StringUtils;

/**
 * 车辆类型 枚举类
 * Created by lianghaoguan on 2018/6/12.
 */
public enum GoodsVehicleTypeEnum {

    CHINA_READY_MADE("1","国产-现车"),
    CHINA_FUTURES("2","国产-期货"),
    JOINT_VENTURE_READY_MADE("3","合资-现车"),
    JOINT_VENTURE_FUTURES("4","合资-期货"),
    INLET_READY_MADE("5","进口-现车"),
    INLET_FUTURES("6","进口-期货");

    private String typeCode;
    private String typeName;

    GoodsVehicleTypeEnum(String typeCode,String typeName){
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 根据编号返回名称
     * @param typeCode 编号
     * @return
     * @author YixinCapital -- lianghaoguan
     *	       2018年6月12日 下午11:06:57
     */
    public static String getNameByCode(String typeCode){
        if(StringUtils.isBlank(typeCode)){
            return null;
        }
        for(GoodsVehicleTypeEnum goodsVehicleTypeEnum:GoodsVehicleTypeEnum.values()){
            if(typeCode.equals(goodsVehicleTypeEnum.getTypeCode())){
                return goodsVehicleTypeEnum.getTypeName();
            }
        }
        return null;
    }
}
