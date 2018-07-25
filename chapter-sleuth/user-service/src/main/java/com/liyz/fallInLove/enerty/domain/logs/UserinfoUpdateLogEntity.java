package com.liyz.fallInLove.enerty.domain.logs;


import com.liyz.fallInLove.enerty.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * @ClassName: UserinfoUpdateLogEntity
 * @Description 用户信息修改日志表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 下午15:00:03
 *
 */
@Entity
@Table(name = "ba_userinfo_update_log")
public class UserinfoUpdateLogEntity extends BZBaseEntiy
{

    private static final long serialVersionUID = 8883248853483365437L;

    /**
     * 用户id
     */
    @Column(name = "userinfo_id",length = 50)
    private String userinfoId;

    /**
     * 操作类型(直接写汉字描述)
     */
    @Column(name = "operate_type",length = 125)
    private String operateType;

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
