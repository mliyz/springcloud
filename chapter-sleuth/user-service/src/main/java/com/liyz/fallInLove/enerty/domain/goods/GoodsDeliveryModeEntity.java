package com.liyz.fallInLove.enerty.domain.goods;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: GoodsDeliveryModeEntity
 * @Description 商品交货方式维护表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 上午11:45:03
 *
 */
@Entity
@Table(name = "ba_goods_delivery_mode")
public class GoodsDeliveryModeEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 8883247742383365437L;

    /**
     * 商品ID
     */
    @Column(name = "goodsinfo_id",length = 50)
    private String goodsinfoId;

    /**
     * 交货方式类型  1-送货上门，2-当地4S店自提，3-买方物流
     */
    @Column(name = "delivery_mode_type",length = 10)
    private String deliveryModeType;

    /**
     * 交货方式描述
     */
    @Column(name = "delivery_mode_desc",length = 50)
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
