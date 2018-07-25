package com.liyz.fallInLove.dto.logs;

import com.yixin.common.utils.BaseDTO;

import java.util.Date;

/**
 *
 * @ClassName: GoodsOperateLogDTO
 * @Description 商品操作日志DTO
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 下午15:00:03
 *
 */
public class GoodsOperateLogDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883248864383365437L;

    /**
     * 商品表id
     */
    private String goodsId;

    /**
     * 商品状态 1-已上架，2-草稿，3-已下架
     */
    private String goodsStatus;

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
