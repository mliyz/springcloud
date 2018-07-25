package com.liyz.fallInLove.dto.logs;

import com.yixin.common.utils.BaseDTO;

import javax.validation.constraints.NotNull;

/**
 *
 * @ClassName: OperateLogDTO
 * @Description 审批、操作类日志
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月29日 下午5:48:01
 *
 */
public class OperateLogDTO extends BaseDTO
{

    private static final long serialVersionUID = 9033228357703342386L;

    /**
     * 日志类型code
     */
    @NotNull(message = "日志类型不能为空")
    private String logTypeCode;

    /**
     * 日志类型名称
     */
    private String logTypeName;

    /**
     * 业务记录id
     */
    @NotNull(message = "业务记录id不能为空")
    private String bussId;

    /**
     * 业务状态code
     */
    @NotNull(message = "业务状态code不能为空")
    private String bussStatusCode;

    /**
     * 业务状态名称
     */
    private String bussStatusName;

    /**
     * 操作人姓名
     */
    @NotNull(message = "操作人姓名不能为空")
    private String operatorName;

    /**
     * 操作人ID
     */
    @NotNull(message = "操作人ID不能为空")
    private String operatorId;

    /**
     * 操作时间
     */
    @NotNull(message = "操作时间不能为空")
    private String operateTime;

    /**
     * 备注
     */
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

    public String getLogTypeName() {
        return logTypeName;
    }

    public void setLogTypeName(String logTypeName) {
        this.logTypeName = logTypeName;
    }

    public String getBussStatusName() {
        return bussStatusName;
    }

    public void setBussStatusName(String bussStatusName) {
        this.bussStatusName = bussStatusName;
    }
}
