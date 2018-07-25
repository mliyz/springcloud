package com.liyz.fallInLove.dto.goods;

import com.yixin.common.utils.BaseDTO;

/**
 *
 * @ClassName: GoodsDeliveryModeDTO
 * @Description 商品交货方式维护DTO
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 上午11:45:03
 *
 */
public class GoodsDeliveryModeDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883247742383365437L;

    /**
     * 商品ID
     */
    private String goodsinfoId;

    /**
     * 交货方式类型  1-送货上门，2-当地4S店自提，3-买方物流
     */
    private String deliveryModeType;

    /**
     * 交货方式描述
     */
    private String deliveryModeDesc;

    public String getGoodsinfoId() {
        return goodsinfoId;
    }

    public void setGoodsinfoId(String goodsinfoId) {
        this.goodsinfoId = goodsinfoId;
    }

    public String getDeliveryModeType() {
        return deliveryModeType;
    }

    public void setDeliveryModeType(String deliveryModeType) {
        this.deliveryModeType = deliveryModeType;
    }

    public String getDeliveryModeDesc() {
        return deliveryModeDesc;
    }

    public void setDeliveryModeDesc(String deliveryModeDesc) {
        this.deliveryModeDesc = deliveryModeDesc;
    }
}
