package com.liyz.fallInLove.dto.logs;

import com.yixin.common.utils.BaseDTO;

import java.util.Date;

/**
 *
 * @ClassName: UserinfoUpdateLogDTO
 * @Description 用户信息修改日志DTO
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 下午15:00:03
 *
 */
public class UserinfoUpdateLogDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883248853483365437L;

    /**
     * 用户id
     */
    private String userinfoId;

    /**
     * 操作类型(直接写汉字描述)
     */
    private String operateType;

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

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
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
