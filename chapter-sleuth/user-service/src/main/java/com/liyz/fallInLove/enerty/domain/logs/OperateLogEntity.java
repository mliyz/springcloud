package com.liyz.fallInLove.enerty.domain.logs;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 审批类型操作日志表
 * @ClassName: OperateLogEntity
 * @Description 审批类型操作日志表
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月29日 下午5:35:52
 *
 */
@Entity
@Table(name = "ba_operate_log")
public class OperateLogEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 8883248864383365437L;

    /**
     * 日志类型code
     */
    @Column(name = "log_type_code",length = 20)
    private String logTypeCode;
    
    /**
     * 业务记录id
     */
    @Column(name = "buss_id")
    private String bussId;

    /**
     * 业务状态code
     */
    @Column(name = "buss_status_code")
    private String bussStatusCode;

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
    private String operateTime;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

    public String getLogTypeCode() {
        return logTypeCode;
    }

    public void setLogTypeCode(String logTypeCode) {
        this.logTypeCode = logTypeCode;
    }

    public String getBussId() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId = bussId;
    }

    public String getBussStatusCode() {
        return bussStatusCode;
    }

    public void setBussStatusCode(String bussStatusCode) {
        this.bussStatusCode = bussStatusCode;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }
}
