package com.liyz.fallInLove.enerty.domain.person;


import com.liyz.fallInLove.enerty.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: VehicleInvoiceInfoEntity
 * @Description 用户开票信息维护表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_vehicle_invoice_info")
public class VehicleInvoiceInfoEntity extends BZBaseEntiy
{

    private static final long serialVersionUID = 9164526043231713456L;

    /**
     * 用户id
     */
    @Column(name = "userinfo_id",length = 50)
    private String userinfoId;

    /**
     * 开票名称
     */
    @Column(name = "invoice_name",length = 125)
    private String invoiceName;

    /**
     * 税务号
     */
    @Column(name = "tax_code",length = 125)
    private String taxCode;

    /**
     * 单位地址
     */
    @Column(name = "company_address",length = 125)
    private String companyAddress;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone",length = 11)
    private String contactPhone;

    /**
     * 开户银行名称
     */
    @Column(name = "bank_name",length = 125)
    private String bankName;

    /**
     * 银行账号
     */
    @Column(name = "bank_account",length = 125)
    private String bankAccount;

    /**
     * （是否默认）
     */
    @Column(name = "is_default")
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
