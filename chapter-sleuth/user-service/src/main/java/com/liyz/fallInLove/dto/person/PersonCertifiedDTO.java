package com.liyz.fallInLove.dto.person;

import com.yixin.common.utils.BaseDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @ClassName: PersonCertifiedDTO
 * @Description 个人认证
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月22日 下午7:23:47
 *
 */
public class PersonCertifiedDTO extends BaseDTO
{

    private static final long serialVersionUID = -986946544851342803L;

    /**
     * 用户id
     */
    private String userinfoId;

    /**
     * 用户职位
     */
    @Size(max = 30, message = "用户职位不能超过30个字")
    @NotNull(message = "用户职位不能为空")
    private String customerPosition;

    /**
     * 认证真实姓名
     */
    @Size(max = 30, message = "真实姓名不能超过30个字")
    @NotNull(message = "认证真实姓名不能为空")
    private String certifiedRealName;

    /**
     * 身份证号
     */
    @NotNull(message = "身份证号不能为空")
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
     * 认证结果（0-未认证，1-待审核，2-认证成功，3-认证失败）
     */
    private String certifiedResult;

    /**
     * 审核意见
     */
    private String suggest;
    
    /**
     * 修改资料的属性类型
     */
    private String moType;

    public String getMoType() {
        return moType;
    }

    public void setMoType(String moType) {
        this.moType = moType;
    }

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
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
