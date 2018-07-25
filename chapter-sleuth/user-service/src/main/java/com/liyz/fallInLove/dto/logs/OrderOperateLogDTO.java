package com.liyz.fallInLove.dto.logs;

import com.yixin.common.utils.BaseDTO;

import java.util.Date;

/**
 *
 * @ClassName: OrderOperateLogDTO
 * @Description 订单操作日志DTO
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 下午15:00:03
 *
 */
public class OrderOperateLogDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883248875483365437L;

    /**
     * 主订单表id
     */
    private String orderId;

    /**
     * 订单状态 0-待接单，1-待发车，2-待收车，3-已完成，4-已失效，5-已取消
     */
    private String orderStatus;

    /**
     * 事件类型(用汉字描述)
     */
    private String evemtType;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 操作人ID
     */
    private String operatorId;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 备注
     */
    private String remarks;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getEvemtType() {
        return evemtType;
    }

    public void setEvemtType(String evemtType) {
        this.evemtType = evemtType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
