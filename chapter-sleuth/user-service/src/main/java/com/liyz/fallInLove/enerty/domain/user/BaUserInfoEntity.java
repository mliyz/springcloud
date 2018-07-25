package com.liyz.fallInLove.enerty.domain.user;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: UserEntity
 * @Description 客户用户类
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月16日 下午3:54:16
 *
 */
@Entity
@Table(name = "ba_user_info")
public class BaUserInfoEntity extends BZBaseEntiy {

	private static final long serialVersionUID = 8710000868340230977L;

	/**
	 * 注册手机号
	 */
	@Column(name = "phone",length = 11)
	private String phone;
	
	/**
	 * 真实姓名
	 */
	@Column(name = "real_name",length = 30)
	private String realName;
	
	/**
     * 公司地点
     */
    @Column(name = "working_place",length = 30)
	private String workingPlace;
	
	/**
	 * 公司名称
	 */
	@Column(name = "company_name",length = 200)
	private String companyName;
	
	/**
	 * 贸易身份
	 */
	@Column(name = "trading_identities",length = 3)
	private String tradingIdentities;
	
	/**
	 * 审核类型：0、未验证，1、验证通过，2、验证未通过
	 */
	@Column(name = "verify_status", nullable = true)
	private Integer verifyStatus;
	
	/**
	 * 加密后的密码
	 */
	@Column(name = "passwd",length = 200)
	private String passwd;
	
	/**
	 * 用户状态：0、锁定，1、正常
	 */
	@Column(name = "user_status", nullable = true)
	private Integer userStatus;

	/**
	 * 头像图片存储路径
	 */
	@Column(name = "head_image",length = 125)
	private String headImage;

	/**
	 * 联系手机号
	 */
	@Column(name = "contact_phone",length = 11)
	private String contactPhone;

	/**
	 * QQ号码
	 */
	@Column(name = "qq",length = 50)
	private String qq;

	/**
	 * 微信号
	 */
	@Column(name = "wechat",length = 50)
	private String wechat;

	/**
	 * 介绍
	 */
	@Column(name = "introduction",length = 125)
	private String introduction;
	
	/**
     * 所在城市名称
     */
    @Column(name = "city_name",length = 30)
    private String cityName;
    
    /**
     * 所在城市编码
     */
    @Column(name = "city_code",length = 30)
    private String cityCode;

	public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTradingIdentities() {
		return tradingIdentities;
	}

	public void setTradingIdentities(String tradingIdentities) {
		this.tradingIdentities = tradingIdentities;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Integer getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(Integer verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

    /**
     * @return the workingPlace
     */
    public String getWorkingPlace() {
        return workingPlace;
    }

    /**
     * @param workingPlace the workingPlace to set
     */
    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}

