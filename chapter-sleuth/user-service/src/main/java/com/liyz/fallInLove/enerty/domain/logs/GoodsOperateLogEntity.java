package com.liyz.fallInLove.enerty.domain.logs;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * @ClassName: GoodsOperateLogEntity
 * @Description 商品操作日志表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 下午15:00:03
 *
 */
@Entity
@Table(name = "ba_goods_operate_log")
public class GoodsOperateLogEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 8883248864383365437L;

    /**
     * 商品表id
     */
    @Column(name = "goods_id",length = 50)
    private String goodsId;

    /**
     * 商品状态 1-已上架，2-草稿，3-已下架
     */
    @Column(name = "goods_status")
    private String goodsStatus;

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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }
}
