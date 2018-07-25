package com.liyz.fallInLove.enerty.domain.verify;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * @ClassName: CertifiedProcessEntity
 * @Description 认证待办表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_certified_process")
public class CertifiedProcessEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 8882145542383365437L;

    /**
     * 用户id
     */
    @Column(name = "userinfo_id",length = 50)
    private String userinfoId;

    /**
     * 认证类型 1-个人认证，2-企业认证
     */
    @Column(name = "certified_type",length = 10)
    private String certifiedType;


	/**
     * 审核人姓名
     */
    @Column(name = "verify_name",length = 50)
    private String verifyName;


    /**
     * 审核时间
     */
    @Column(name = "verify_date")
    private Date verifyDate;


    /**
     * 审核状态 0-未审核、1-审核通过，2-已驳回
     */
    @Column(name = "verify_status",length = 10)
    private String verifyStatus = "0";

    /**
     * 公司名称
     */
    @Column(name = "company_name",length = 125)
    private String companyName;

    /**
     * 公司地址
     */
    @Column(name = "company_address",length = 125)
    private String companyAddress;
    /**
     * 企业认证记录id
     */
    @Column(name = "enterprise_certify_id", length = 50)
    private String enterpriseCertifyId;

    public String getEnterpriseCertifyId() {
		return enterpriseCertifyId;
	}

	public void setEnterpriseCertifyId(String enterpriseCertifyId) {
		this.enterpriseCertifyId = enterpriseCertifyId;
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

	public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
    }


    public String getVerifyName() {
        return verifyName;
    }

    public void setVerifyName(String verifyName) {
        this.verifyName = verifyName;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }
    public String getCertifiedType() {
		return certifiedType;
	}
	public void setCertifiedType(String certifiedType) {
		this.certifiedType = certifiedType;
	}
}
