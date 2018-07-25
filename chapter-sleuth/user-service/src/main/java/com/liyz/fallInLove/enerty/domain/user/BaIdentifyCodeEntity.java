package com.liyz.fallInLove.enerty.domain.user;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: BaUserLoginLogEntity
 * @Description 验证码记录表
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月16日 下午4:45:03
 *
 */
@Entity
@Table(name = "ba_identify_code")
public class BaIdentifyCodeEntity extends BZBaseEntiy {

	private static final long serialVersionUID = -9164526030421603345L;
	
	/**
	 * 手机号
	 */
	@Column(name = "phone",length = 11)
	private String phone;
	
	/**
	 * 验证码类型 0-注册，1-重置密码，2-实名认证
	 */
	@Column(name = "code_type",length = 200)
	private String codeType;
	
	/**
	 * 手机验证码
	 */
	@Column(name = "verification_code")
	private Integer verificationCode;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public Integer getVerificationCode() {
		return verificationCode;
	}


	public void setVerificationCode(Integer verificationCode) {
		this.verificationCode = verificationCode;
	}
}

