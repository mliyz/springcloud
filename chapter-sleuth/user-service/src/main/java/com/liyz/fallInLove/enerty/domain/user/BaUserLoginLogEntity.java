package com.liyz.fallInLove.enerty.domain.user;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ClassName: BaUserLoginLogEntity
 * @Description 记录用户登陆错误日志
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月16日 下午4:45:03
 *
 */
@Entity
@Table(name = "ba_user_login_log")
public class BaUserLoginLogEntity extends BZBaseEntiy {

	private static final long serialVersionUID = -2803390946959155992L;

	/**
     * 用户id
     */
    @Column(name = "userinfo_id",length = 50)
    private String userinfoId;

	/**
	 * 连续登陆错误次数
	 */
	@Column(name = "pwd_error_count", nullable = true)
	private Integer pwdErrorCount;

	/**
     * 锁定截止时间
     */
    @Column(name = "lock_time")
    private Date lockTime;

	public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
    }

    public Integer getPwdErrorCount() {
		return pwdErrorCount;
	}

	public void setPwdErrorCount(Integer pwdErrorCount) {
		this.pwdErrorCount = pwdErrorCount;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public static BaUserLoginLogEntity getLockedUserByUserId(String userId){

		Map<String, Object> parmMap = new HashMap<>();
		parmMap.put("userinfoId", userId);
		parmMap.put("nowTime", new Date());
		parmMap.put("deleted", false);
		StringBuilder jpql = new StringBuilder();
		jpql.append("select entity from BaUserLoginLogEntity entity ")
		    .append("where entity.userinfoId = :userinfoId and entity.deleted =:deleted ")
		    .append("and entity.lockTime > :nowTime ");
		BaUserLoginLogEntity entity= getRepository().createJpqlQuery(jpql.toString()).setParameters(parmMap).singleResult();
		return entity;
	}
}

