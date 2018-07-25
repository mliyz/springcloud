package com.liyz.fallInLove.dto.person;

import com.yixin.common.utils.BaseDTO;

/**
 * Created by lianghaoguan on 2018/5/22.
 * 企业认证DTO
 */
public class EnterpriseCertifiedDTO extends BaseDTO
{

    private static final long serialVersionUID = 9164526043231603456L;

    /**
     * 用户id
     */
    private String userinfoId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 用户职位
     */
    private String customerPosition;

    /**
     * 营业执照图片存储路径
     */
    private String businessLicenseImage;

    /**
     * 认证结果（0-未认证，1-待审核，2-认证成功，3-认证失败）
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

    public String getCustomerPosition() {
        return customerPosition;
    }

    public void setCustomerPosition(String customerPosition) {
        this.customerPosition = customerPosition;
    }

    public String getBusinessLicenseImage() {
        return businessLicenseImage;
    }

    public void setBusinessLicenseImage(String businessLicenseImage) {
        this.businessLicenseImage = businessLicenseImage;
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
