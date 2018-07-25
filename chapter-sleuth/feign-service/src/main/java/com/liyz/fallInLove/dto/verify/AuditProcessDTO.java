package com.liyz.fallInLove.dto.verify;

import com.yixin.common.utils.BaseDTO;

import javax.validation.constraints.NotNull;

/**
 *
 * @ClassName: AduitProcessDTO
 * @Description 认证审核操作DTO
 * @author  YixinCapital -- lizhongxin
 * @date  2018年5月29日 下午7:49:07
 *
 */
public class AuditProcessDTO extends BaseDTO
{

	/**
     * 用户id
     */
	@NotNull(message="用户id不能为空")
    private String userinfoId;

    /**
	 * 认证类型: 1-实名认证，2-企业认证
	 */
//	@NotNull(message="认证类型不能为空")
	private String certifiedType;

    /**
     * 用户职位
     */
    private String customerPosition;

    /**
     * 认证真实姓名
     */
    private String certifiedRealName;

    /**
     * 身份证号
     */
    private String idcard;


	/**
     * 身份证正面照片存储路径
     */
    private String idcardFrontImage;

    /**
     * 身份证反面照片存储路径
     */
    private String idcardBackImage;

    /**
     * 工作名片照片存储路径
     */
    private String businesscardImage;

    /**
     * 营业执照图片存储路径
     */
    private String businessLicenseImage;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String companyAddress;


    /**
     * 认证结果（1-待审核，2-认证成功，3-认证失败）
     */
    private String certifiedResult;

    /**
     * 审核意见
     */
    private String suggest;

	public String getUserinfoId() {
		return userinfoId;
	}

	public void setUserinfoId(String userinfoId) {
		this.userinfoId = userinfoId;
	}

	public String getCertifiedType() {
		return certifiedType;
	}

	public void setCertifiedType(String certifiedType) {
		this.certifiedType = certifiedType;
	}

	public String getCustomerPosition() {
		return customerPosition;
	}

	public void setCustomerPosition(String customerPosition) {
		this.customerPosition = customerPosition;
	}

	public String getCertifiedRealName() {
		return certifiedRealName;
	}

	public void setCertifiedRealName(String certifiedRealName) {
		this.certifiedRealName = certifiedRealName;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdcardFrontImage() {
		return idcardFrontImage;
	}

	public void setIdcardFrontImage(String idcardFrontImage) {
		this.idcardFrontImage = idcardFrontImage;
	}

	public String getIdcardBackImage() {
		return idcardBackImage;
	}

	public void setIdcardBackImage(String idcardBackImage) {
		this.idcardBackImage = idcardBackImage;
	}

	public String getBusinesscardImage() {
		return businesscardImage;
	}

	public void setBusinesscardImage(String businesscardImage) {
		this.businesscardImage = businesscardImage;
	}

	public String getBusinessLicenseImage() {
		return businessLicenseImage;
	}

	public void setBusinessLicenseImage(String businessLicenseImage) {
		this.businessLicenseImage = businessLicenseImage;
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

	public String getCertifiedResult() {
		return certifiedResult;
	}

	public void setCertifiedResult(String certifiedResult) {
		this.certifiedResult = certifiedResult;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}


}

