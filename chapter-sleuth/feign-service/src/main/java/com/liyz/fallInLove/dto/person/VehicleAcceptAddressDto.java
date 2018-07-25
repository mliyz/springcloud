package com.liyz.fallInLove.dto.person;

import com.yixin.common.utils.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @ClassName: VehicleAcceptAddressDto
 * @Description 用户接收地址
 * @author  YixinCapital -- liyuzhang
 * @date  2018年5月21日 下午5:17:03
 *
 */
public class VehicleAcceptAddressDto extends BaseDTO
{

    private static final long serialVersionUID = -6097776399408222706L;

    /**
     * 接车信息ID
     */
    private String id;

    /**
     * 用户id
     */
    @NotBlank(message = "接收人不能为空")
    private String userinfoId;

    /**
     * 接收人名称
     */
    @NotBlank(message = "接收人不能为空")
    private String accepterName;

    /**
     * 所在地区编号
     */
    @NotBlank(message = "所在地区编号不能为空")
    private String regionCode;

    /**
     * 所在地区名称
     */
    @NotBlank(message = "所在地区名称不能为空")
    private String regionName;

    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空")
    private String address;

    /**
     * 邮政编号
     */
    @NotBlank(message = "邮政编号不能为空")
    private String postCode;

    /**
     * 接收人电话
     */
    @NotBlank(message = "接收人电话不能为空")
    private String accepterPhone;

    /**
     * 是否默认
     */
    private Boolean sDefault = false;

    /**
     * 地址类型（0-接车地址，1-收票地址）
     */
    @NotBlank(message = "接收地址类型不能为空")
    private String addrType;
    /***
     * 是否删除状态，true为已删除，false为未删除
     */
    private Boolean deleted = false;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }
}
