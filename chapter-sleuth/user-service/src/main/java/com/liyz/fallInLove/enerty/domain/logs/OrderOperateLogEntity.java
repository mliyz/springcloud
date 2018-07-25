package com.liyz.fallInLove.enerty.domain.logs;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * @ClassName: OrderOperateLogEntity
 * @Description 订单操作日志表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 下午15:00:03
 *
 */
@Entity
@Table(name = "ba_order_operate_log")
public class OrderOperateLogEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 8883248875483365437L;

    /**
     * 主订单表id
     */
    @Column(name = "order_id",length = 50)
    private String orderId;

    /**
     * 订单状态 0-待接单，1-待发车，2-待收车，3-已完成，4-已失效，5-已取消
     */
    @Column(name = "order_status",length = 50)
    private String orderStatus;

    /**
     * 事件类型(用汉字描述)
     */
    @Column(name = "evemtType",length = 125)
    private String evemtType;

    /**
     * 操作人姓名
     */
    @Column(name = "operator_name",length = 50)
    private String operatorName;

    /**
     * 操作人ID
     */
    @Column(name = "operator_id",length = 50)
    private String operatorId;

    /**
     * 操作时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 备注
     */
    @Column(name = "remarks")
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
