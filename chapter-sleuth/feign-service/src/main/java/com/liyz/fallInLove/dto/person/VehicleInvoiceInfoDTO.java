/**
 * Copyright © 2018 Yixin Info. Tech Ltd. All rights reserved.
 * @Title: VehicleInvoiceInfoDto.java
 * @Package com.yixin.vehiclemart.dto.invoice
 * @author mjj
 * @date 2018年5月21日 下午5:12:56
 * @version V1.0
 */
package com.liyz.fallInLove.dto.person;

import com.yixin.common.utils.BaseDTO;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: VehicleInvoiceInfoDto
 * @Description 用户开票信息dto
 * @author YixinCapital -- mjj
 * @date 2018年5月21日 下午5:12:56
 *
 */
public class VehicleInvoiceInfoDTO extends BaseDTO
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 8778171064742429586L;

    /**
     * 用户id
     */
    @NotNull(message = "id不能为空")
    private String userinfoId;

    /**
     * 开票名称
     */
    @NotNull(message = "开票名称不能为空")
    private String invoiceName;

    /**
     * 税务号
     */
    @NotNull(message = "税务号不能为空")
    private String taxCode;

    /**
     * 单位地址
     */
    @NotNull(message = "单位地址不能为空")
    private String companyAddress;

    /**
     * 联系电话
     */
    @NotNull(message = "联系电话不能为空")
    private String contactPhone;

    /**
     * 开户银行名称
     */
    @NotNull(message = "开户银行名称不能为空")
    private String bankName;

    /**
     * 银行账号
     */
    @NotNull(message = "银行账号不能为空")
    private String bankAccount;

    /**
     * （是否默认）
     */
    private Boolean sDefault;

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Boolean getsDefault() {
        return sDefault;
    }

    public void setsDefault(Boolean sDefault) {
        this.sDefault = sDefault;
    }
}
