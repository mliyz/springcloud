/**
 * Copyright © 2018 Yixin Info. Tech Ltd. All rights reserved.
 * @Title: CertifiedProcessDTO.java
 * @Package com.yixin.vehiclemart.dto.verify
 * @author lizhongxin
 * @date 2018年5月29日 上午10:23:33
 * @version V1.0
 */
package com.liyz.fallInLove.dto.verify;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liyz.common.util.DateUtil;
import com.liyz.fallInLove.enums.verify.VerifyStatusEnum;
import com.yixin.common.utils.BaseDTO;
import com.yixin.common.utils.serializer.JsonDateDeserializer;
import com.yixin.common.utils.serializer.JsonDateTimeSerializer;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName: CertifiedProcessDTO
 * @Description 认证处理DTO
 * @author YixinCapital -- lizhongxin
 * @date 2018年5月29日 上午10:23:33
 *
 */
public class CertifiedProcessDTO extends BaseDTO
{

	private static final long serialVersionUID = 7312661999839498483L;
	
	/**
	 * 用户id
	 */
	@NotNull
	private String userinfoId;
	
	/**
	 * 注册手机号
	 */
	private String phone;
	
	/**
	 * 所在城市
	 */
	private String cityName;
	/**
	 * 所在城市编码
	 */
	private String cityCode;

	/**
	 * 注册时姓名
	 */
	private String registerRealName;
	/**
	 * 认证真实姓名
	 */
	private String certifiedRealName;

	/**
	 * 认证类型: 1-实名认证，2-企业认证
	 */
	private String certifiedType;
	/**
	 * 认证类型描述: 1-实名认证，2-企业认证
	 */
	private String certifiedTypeDesc;

	/**
	 * 审核人姓名
	 */
	private String verifyName;

	/**
	 * 审核时间
	 */
	/*@JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)*/
	private String verifyDate;

	/**
	 * 审核状态 0-未审核、1-审核通过，2-已驳回
	 */
	private String verifyStatus;
	/**
	 * 处理状态： 0-待处理、1-已处理 、查询全部时此字段不传值
	 */
	private String dealStatus;
	
	/**
     * 身份证号
     */
    private String idcard;
    
    /**
     * 提交时间
     */
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
	private Date submitTime;
	
	 /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String companyAddress;
    
    /**
     * 提交开始时间
     */
    private String submitStartTime;
    /**
     * 提交结束时间
     */
    private String submitEndTime;
    
    /**
     * 用户职位
     */
    private String customerPosition;
    
    public CertifiedProcessDTO() {}
    
	public CertifiedProcessDTO(String id, String userinfoId, String certifiedType, String verifyName, Date verifyDate,
			String verifyStatus, Date submitTime, String companyName, String companyAddress,
			String phone, String cityName, String registerRealName, String certifiedRealName, String idcard,String customerPosition) {
		    this.setId(id);
		    this.userinfoId = userinfoId;
			this.certifiedType = certifiedType;
			this.verifyName = verifyName;
			this.verifyDate = DateUtil.dateToString(verifyDate, DateUtil.DATE_FORMAT_WITH_SECOND);
			this.verifyStatus = VerifyStatusEnum.getStatusDescByCode(verifyStatus);
			this.submitTime = submitTime;
			this.companyName = companyName;
			this.companyAddress = companyAddress;
		
			this.phone = phone;
			this.cityName = cityName;
			this.registerRealName = registerRealName;
			this.certifiedRealName = certifiedRealName;
			this.idcard = idcard;
			this.customerPosition = customerPosition;
			if ("1".equals(certifiedType)) {
				this.certifiedTypeDesc = "实名认证";
			} else {
				this.certifiedTypeDesc = "企业认证";
			}
		
	}

	public String getUserinfoId() {
		return userinfoId;
	}

	public void setUserinfoId(String userinfoId) {
		this.userinfoId = userinfoId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegisterRealName() {
		return registerRealName;
	}

	public void setRegisterRealName(String registerRealName) {
		this.registerRealName = registerRealName;
	}

	public String getCertifiedRealName() {
		return certifiedRealName;
	}

	public void setCertifiedRealName(String certifiedRealName) {
		this.certifiedRealName = certifiedRealName;
	}

	public String getCertifiedType() {
		return certifiedType;
	}

	public void setCertifiedType(String certifiedType) {
		this.certifiedType = certifiedType;
	}

	public String getVerifyName() {
		return verifyName;
	}

	public void setVerifyName(String verifyName) {
		this.verifyName = verifyName;
	}

	public String getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(String verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public String getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getSubmitStartTime() {
		return submitStartTime;
	}

	public void setSubmitStartTime(String submitStartTime) {
		this.submitStartTime = submitStartTime;
	}

	public String getSubmitEndTime() {
		return submitEndTime;
	}

	public void setSubmitEndTime(String submitEndTime) {
		this.submitEndTime = submitEndTime;
	}

	public String getCertifiedTypeDesc() {
		return certifiedTypeDesc;
	}

	public void setCertifiedTypeDesc(String certifiedTypeDesc) {
		this.certifiedTypeDesc = certifiedTypeDesc;
	}

	public String getCustomerPosition() {
		return customerPosition;
	}

	public void setCustomerPosition(String customerPosition) {
		this.customerPosition = customerPosition;
	}

	
 

}
