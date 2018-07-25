package com.liyz.fallInLove.dto.user;

import com.yixin.common.utils.BaseDTO;

/**
 *  重置密码
 * @author YixinCapital -- liyuzhang
 *         2018/5/18 17:52
*/
public class BaPwdRestDTO extends BaseDTO
{

    private static final long serialVersionUID = -2594885702719136338L;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 旧密码
     */
    private String oldPasswd;

    /**
     * 新密码
     */
    private String newPasswd;

    /**
     * 确认密码
     */
    private String  verifyPasswd;
    /**
     * 验证码类型 0-注册，1-重置密码，2-实名认证
     */
    private String codeType;
    /**
     * 手机验证码
     */
    private Integer verificationCode = new Integer(1);

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOldPasswd() {
        return oldPasswd;
    }

    public void setOldPasswd(String oldPasswd) {
        this.oldPasswd = oldPasswd;
    }

    public String getNewPasswd() {
        return newPasswd;
    }

    public void setNewPasswd(String newPasswd) {
        this.newPasswd = newPasswd;
    }

    public Integer getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Integer verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerifyPasswd() {
        return verifyPasswd;
    }

    public void setVerifyPasswd(String verifyPasswd) {
        this.verifyPasswd = verifyPasswd;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
}
