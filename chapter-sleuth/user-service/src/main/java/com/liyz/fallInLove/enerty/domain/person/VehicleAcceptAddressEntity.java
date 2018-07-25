package com.liyz.fallInLove.enerty.domain.person;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: VehicleAcceptAddressEntity
 * @Description 用户接收地址维护表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_vehicle_accept_address")
public class VehicleAcceptAddressEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 9164537031231603456L;

    /**
     * 用户id
     */
    @Column(name = "userinfo_id",length = 50)
    private String userinfoId;

    /**
     * 接收人名称
     */
    @Column(name = "accepter_name",length = 50)
    private String accepterName;

    /**
     * 所在地区编号
     */
    @Column(name = "region_code",length = 50)
    private String regionCode;

    /**
     * 所在地区名称
     */
    @Column(name = "region_name",length = 125)
    private String regionName;

    /**
     * 详细地址
     */
    @Column(name = "address",length = 255)
    private String address;

    /**
     * 邮政编号
     */
    @Column(name = "post_code",length = 50)
    private String postCode;

    /**
     * 接收人电话
     */
    @Column(name = "accepter_phone",length = 50)
    private String accepterPhone;

    /**
     * 是否默认
     */
    @Column(name = "is_default")
    private Boolean sDefault;

    /**
     * 地址类型（0-接车地址，1-收票地址）
     */
    @Column(name = "addr_type",length = 10)
    private String addrType;

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
    }

    public String getAccepterName() {
        return accepterName;
    }

    public void setAccepterName(String accepterName) {
        this.accepterName = accepterName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAccepterPhone() {
        return accepterPhone;
    }

    public void setAccepterPhone(String accepterPhone) {
        this.accepterPhone = accepterPhone;
    }

    public Boolean getsDefault() {
        return sDefault;
    }

    public void setsDefault(Boolean sDefault) {
        this.sDefault = sDefault;
    }

    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }
}
