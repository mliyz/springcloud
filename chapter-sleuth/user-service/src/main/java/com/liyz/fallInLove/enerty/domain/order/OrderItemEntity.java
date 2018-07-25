package com.liyz.fallInLove.enerty.domain.order;

import com.liyz.fallInLove.enerty.domain.BZBaseEntiy;
import com.yixin.common.system.domain.BaseEntity;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @ClassName: orderItemEntity
 * @Description 子订单表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 下午14:15:03
 *
 */
@Entity
@Table(name = "ba_order_item")
public class OrderItemEntity extends BZBaseEntiy
{

    private static final long serialVersionUID = 8883248842384465437L;

    /**
     * 子订单编号
     */
    @Column(name = "child_order_no",length = 50)
    private String childOrderNo;

    /**
     * 主订单编号
     */
    @Column(name = "order_no",length = 50)
    private String orderNo;

    /**
     * 商品数量
     */
    @Column(name = "goods_quantity")
    private Integer goodsQuantity;

    /**
     * 颜色
     */
    @Column(name = "color_name",length = 20)
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

    /**
     *
     * @Description: 根据主订单号获取对应的
     * @param orderNo
     * @return Map<String,OrderItemEntity> 其中 key = childOrderNo
     * @throws
     * @author YixinCapital -- lizhongxin
     *	       2018年6月8日 上午10:49:56
     */
    public static Map<String,OrderItemEntity> getOrderItemsByOrderNo(String orderNo){

    	if(StringUtils.isBlank(orderNo)) {
    		return Collections.emptyMap();
    	}
    	Map<String,Object> propValues = new HashMap<>();
    	propValues.put("orderNo", orderNo);
    	propValues.put("deleted", false);
    	List<OrderItemEntity> list = BaseEntity.findByProperties(OrderItemEntity.class, propValues);
    	Map<String,OrderItemEntity> resultMap = new HashMap<>();
    	if(list!=null && !list.isEmpty()) {
    		for (OrderItemEntity entity : list) {
    			resultMap.put(entity.getChildOrderNo(), entity);
			}
    	}
    	return resultMap;
    }
}
