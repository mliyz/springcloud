package com.liyz.fallInLove.enums.goods;

import org.apache.commons.lang3.StringUtils;

/**
 * 商品状态枚举类
 * Created by lianghaoguan on 2018/6/12.
 */
public enum GoodsStatusEnum {

    UP_SHELF("1","已上架"),
    DRAFT("2","草稿"),
    DOWN_SHELF("3","已下架");

    private String typeCode;
    private String typeName;

    GoodsStatusEnum(String typeCode, String typeName){
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
        for(GoodsStatusEnum typeEnum: GoodsStatusEnum.values()){
            if(typeCode.equals(typeEnum.getTypeCode())){
                return typeEnum.getTypeName();
            }
        }
        return null;
    }
}
