/**
 * Copyright © 2018 Yixin Info. Tech Ltd. All rights reserved.
 * @Title: CertifiedProcessDTO.java
 * @Package com.yixin.vehiclemart.dto.verify
 * @author lizhongxin
 * @date 2018年5月29日 上午10:23:33
 * @version V1.0
 */
package com.liyz.fallInLove.dto.verify;

import com.yixin.common.utils.BaseDTO;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: VerifyProcessDTO
 * @Description 创建认证待办入参DTO
 * @author YixinCapital -- lizhongxin
 * @date 2018年5月29日 上午10:23:33
 *
 */
public class VerifyProcessCreateDTO extends BaseDTO
{


	private static final long serialVersionUID = 5682657603527346598L;

	/**
	 * 用户id
	 */
	@NotNull
	private String userinfoId;

	/**
	 * 认证类型: 1-实名认证，2-企业认证
	 */
	@NotNull
	private String certifiedType;

	 /**
     * 公司名称(企业认证时必填)
     */
    private String companyName;

    /**
     * 公司地址(企业认证时必填)
     */
    private String companyAddress;
    /**
     * 企业认证记录ID(企业认证时必填)
     */
    private String enterpriseCertifyId;



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

	public String getEnterpriseCertifyId() {
		return enterpriseCertifyId;
	}

	public void setEnterpriseCertifyId(String enterpriseCertifyId) {
		this.enterpriseCertifyId = enterpriseCertifyId;
	}


}
