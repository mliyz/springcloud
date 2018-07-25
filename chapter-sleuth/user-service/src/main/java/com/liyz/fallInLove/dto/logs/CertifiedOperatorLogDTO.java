package com.liyz.fallInLove.dto.logs;

import com.yixin.common.utils.BaseDTO;

import java.util.Date;

/**
 *
 * @ClassName: CertifiedOperatorLogDTO
 * @Description 认证操作日志DTO
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 下午15:00:03
 *
 */
public class CertifiedOperatorLogDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883256653483365437L;

    /**
     * 用户id
     */
    private String userinfoId;

    /**
     * 审核状态 0-未审核、1-审核通过，2-已驳回
     */
    private String certityStatus;

    /**
     * 审核类型 1-个人，2-企业
     */
    private String certityType;

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

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
    }

    public String getCertityStatus() {
        return certityStatus;
    }

    public void setCertityStatus(String certityStatus) {
        this.certityStatus = certityStatus;
    }

    public String getCertityType() {
        return certityType;
    }

    public void setCertityType(String certityType) {
        this.certityType = certityType;
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
