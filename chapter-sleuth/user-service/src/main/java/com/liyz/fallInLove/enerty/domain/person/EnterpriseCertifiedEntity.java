package com.liyz.fallInLove.enerty.domain.person;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: EnterpriseCertifiedEntity
 * @Description 企业认证表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_enterprise_certified")
public class EnterpriseCertifiedEntity extends BZBaseEntiy{

    private static final long serialVersionUID = 9164526043231603456L;

    /**
     * 用户id
     */
    @Column(name = "userinfo_id",length = 50)
    private String userinfoId;

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
     * 营业执照图片存储路径
     */
    @Column(name = "business_license_image")
    private String businessLicenseImage;

    /**
     * 认证结果（1-待审核，2-认证成功，3-认证失败）
     */
    @Column(name = "certified_result",length = 10)
    private String certifiedResult = "1";

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

    /**
     * 通过用户id,查询最近提交的企业认证信息
     *
     * @param userinfoId
     * @return
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月30日 上午11:12:33
     */
    public static EnterpriseCertifiedEntity getEnterpriseCertifiedByUserInfoId(String userinfoId){
        StringBuilder jpql = new StringBuilder("select entity from EnterpriseCertifiedEntity entity  where entity.deleted = false  and entity.userinfoId = ? ");
        jpql.append(" order by entity.createTime desc ");
        List<Object> conditionVals = new ArrayList<>();
        conditionVals.add(userinfoId);

        List<EnterpriseCertifiedEntity> list = getRepository().createJpqlQuery(jpql.toString())
                .setParameters(conditionVals).list();

        if(list!=null && !list.isEmpty()){
            return list.get(0);
        }
        return null;

    }
}
