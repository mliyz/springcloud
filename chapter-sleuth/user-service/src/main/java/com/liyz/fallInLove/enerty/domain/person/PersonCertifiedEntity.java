package com.liyz.fallInLove.enerty.domain.person;


import com.liyz.fallInLove.enerty.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: PersonCertifiedEntity
 * @Description 个人认证表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_person_certified")
public class PersonCertifiedEntity extends BZBaseEntiy
{

    private static final long serialVersionUID = 9164526031231603456L;

    /**
     * 用户id
     */
    @Column(name = "userinfo_id",length = 50)
    private String userinfoId;

    /**
     * 用户职位
     */
    @Column(name = "customer_position",length = 50)
    private String customerPosition;

    /**
     * 认证真实姓名
     */
    @Column(name = "certified_real_name",length = 50)
    private String certifiedRealName;

    /**
     * 身份证号
     */
    @Column(name = "idcard",length = 50)
    private String idcard;

    /**
     * 身份证正面照片存储路径
     */
    @Column(name = "idcard_front_image")
    private String idcardFrontImage;

    /**
     * 身份证反面照片存储路径
     */
    @Column(name = "idcard_back_image")
    private String idcardBackImage;

    /**
     * 工作名片照片存储路径
     */
    @Column(name = "businesscard_image")
    private String businesscardImage;

    /**
     * 认证结果（1-待审核，2-认证成功，3-认证失败）
     */
    @Column(name = "certified_result",length = 10)
    private String certifiedResult;

    /**
     * 审核意见
     */
    @Column(name = "suggest")
    private String suggest;

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
