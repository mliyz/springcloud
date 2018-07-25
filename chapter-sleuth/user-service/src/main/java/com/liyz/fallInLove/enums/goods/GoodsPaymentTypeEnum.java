package com.liyz.fallInLove.enums.goods;

import org.apache.commons.lang3.StringUtils;

/**
 * 商品交易类型 枚举类
 * Created by lianghaoguan on 2018/6/12.
 */
public enum GoodsPaymentTypeEnum {

    FULL_PAYMENT("1","全款发车"),
    DEPOSIT_PAYMENT("2","定金发车");

    private String typeCode;
    private String typeName;

    GoodsPaymentTypeEnum(String typeCode,String typeName){
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
        for(GoodsPaymentTypeEnum goodsPaymentTypeEnum:GoodsPaymentTypeEnum.values()){
            if(typeCode.equals(goodsPaymentTypeEnum.getTypeCode())){
                return goodsPaymentTypeEnum.getTypeName();
            }
        }
        return null;
    }

}
