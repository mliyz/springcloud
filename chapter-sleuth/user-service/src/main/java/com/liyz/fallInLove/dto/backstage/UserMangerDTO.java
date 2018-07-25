package com.liyz.fallInLove.dto.backstage;

import com.yixin.common.utils.BaseDTO;

/**
 * Created by lianghaoguan on 2018/5/22.
 * 用户管理界面DTO
 */
public class UserMangerDTO extends BaseDTO
{

    private static final long serialVersionUID = 7064037020894010560L;

    /**
     * 注册姓名
     */
    private String realName;

    /**
     * 认证真实姓名
     */
    private String certifiedRealName;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 工作地点
     */
    private String workingPlace;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 用户职位
     */
    private String customerPosition;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String companyAddress;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCertifiedRealName() {
        return certifiedRealName;
    }

    public void setCertifiedRealName(String certifiedRealName) {
        this.certifiedRealName = certifiedRealName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
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

    public String getCustomerPosition() {
        return customerPosition;
    }

    public void setCustomerPosition(String customerPosition) {
        this.customerPosition = customerPosition;
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
}
