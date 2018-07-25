package com.liyz.fallInLove.dto.user;

import com.yixin.common.utils.BaseDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @ClassName: UserInfoDTO
 * @Description 外部用户dto
 * @author YixinCapital -- yangfei02
 * @date 2018年5月17日 上午11:12:06
 *
 */
public class BaUserInfoDTO extends BaseDTO
{

    private static final long serialVersionUID = 7065037020894010560L;

    /**
     * 注册手机号
     */
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = "(\\+\\d+)?1[34578]\\d{9}$", message = "您输入的手机号码有误，请重新输入")
    private String phone;

    /**
     * 真实姓名
     */
    @NotNull(message = "真实姓名不能为空")
    @Pattern(regexp = "^[\u4e00-\u9fa5]{2,50}$", message = "姓名需为小于50字符的汉字，请重新输入")
    private String realName;

    /**
     * 公司名称
     */
    @NotNull(message = "公司名称不能为空")
    private String companyName;

    /**
     * 公司地点
     */
    @NotNull(message = "公司地点不能为空")
    private String workingPlace;

    /**
     * 贸易身份
     */
    @NotNull(message = "贸易身份不能为空")
    private String tradingIdentities;

    /**
     * 审核类型：0、未验证，1、验证通过，2、验证未通过
     */
    private Integer verifyStatus;

    /**
     * 加密后的密码
     */
    @NotNull(message = "密码不能为空")
    private String passwd;

    /**
     * 确认密码
     */
    @NotNull(message = "确认密码不能为空")
    private String rePasswd;

    /**
     * 用户状态：0、锁定，1、正常
     */
    private Integer userStatus;

    /**
     * 验证码
     */
    @NotNull(message = "验证码不能为空")
    private String verifyCode;

    /**
     * 头像图片存储路径
     */
    private String headImage;

    /**
     * 联系手机号
     */
    private String contactPhone;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 修改资料的属性类型
     */
    private String moType;

    /**
     * 认证真实姓名
     */
    private String certifiedRealName;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 是否勾选自动登录，默认不自动登录
     */
    private boolean rememberMe = false;

    /**
     * 所在城市名称
     */
    private String cityName;

    /**
     * 所在城市编码
     */
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

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
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

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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

    /**
     * @return the rePasswd
     */
    public String getRePasswd() {
        return rePasswd;
    }

    /**
     * @param rePasswd the rePasswd to set
     */
    public void setRePasswd(String rePasswd) {
        this.rePasswd = rePasswd;
    }

    /**
     * @return the verifyCode
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * @param verifyCode the verifyCode to set
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getMoType() {
        return moType;
    }

    public void setMoType(String moType) {
        this.moType = moType;
    }

    /**
     * @return the rememberMe
     */
    public boolean isRememberMe() {
        return rememberMe;
    }

    /**
     * @param rememberMe the rememberMe to set
     */
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
