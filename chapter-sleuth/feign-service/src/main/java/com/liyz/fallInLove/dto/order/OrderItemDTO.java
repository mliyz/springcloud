package com.liyz.fallInLove.dto.order;

import com.yixin.common.utils.BaseDTO;

import javax.validation.constraints.NotNull;

/**
 *
 * @ClassName: orderItemDTO
 * @Description 子订单DTO
 * @author YixinCapital -- lianghaoguan
 * @date 2018年5月28日 下午14:15:03
 *
 */
public class OrderItemDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883248842384465437L;

    /**
     * 子订单编号
     */
    private String childOrderNo;

    /**
     * 主订单编号
     */
    private String orderNo;

    /**
     * 商品数量
     */
    @NotNull(message = "商品数量不能为空")
    private Integer goodsQuantity;

    /**
     * 颜色
     */
    @NotNull(message = "颜色不能为空")
    private String colorName;

    public String getChildOrderNo() {
        return childOrderNo;
    }

    public void setChildOrderNo(String childOrderNo) {
        this.childOrderNo = childOrderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(Integer goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
