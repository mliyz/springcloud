package com.liyz.fallInLove.dto.goods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yixin.common.utils.YxCurrentUserDTO;
import com.yixin.common.utils.serializer.JsonDateDeserializer;
import com.yixin.common.utils.serializer.JsonDateTimeSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @ClassName: GoodsInfoDTO
 * @Description 商品信息DTO
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 上午10:45:03
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@Document(indexName="vehiclemart",type="goodsInfo",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class GoodsInfoDTO implements Serializable {

    private static final long serialVersionUID = 8882146642383365437L;

    /**
     * 主品牌ID
     */
    private String carMasterBrandId;

    /**
     * 主品牌名称
     */
    private String carMasterBrandName;

    /**
     * 品牌id
     */
    private String carBrandId;

    /**
     * 品牌名称
     */
    private String carBrandName;

    /**
     * 车型id
     */
    private String carModelId;

    /**
     * 车型名称
     */
    private String carModelName;

    /**
     * 车款id
     */
    private String carStyleId;

    /**
     * 车款名称
     */
    private String carStyleName;

    /**
     * 车辆类型：1-国产-现车，2-国产-期货，3-合资-现车，4-合资-期货，5-进口-现车，6-进口-期货
     */
    private String vehicleType;

    /**
     * 车源所在地编号
     */
    private String garageCityCode;

    /**
     * 车源所在地名称
     */
    private String garageCityName;

    /**
     * 手续 1-随车，2-邮寄
     */
    private String formalities;

    /**
     * 指导价
     */
    private String guidePrice;

    /**
     * 折扣价
     */
    private String discountPrice;

    /**
     * 售价
     */
    private String sellPrice;

    /**
     * 交易方式. 1-全款发车,2-定金发车
     */
    private String paymentType;

    /**
     * 支付返佣金额
     */
    private String paymentCommission;

    /**
     * 定金比例
     */
    private String depositRatio;

    /**
     * 发票类型 1-增票、2-零售票
     */
    private String invoiceType;

    /**
     * 起订台数
     */
    private Integer minQuantity;

    /**
     * 发车时间
     */
    private Date departureTime;

    /**
     * 运费承担方 1-卖家承担,2-买家承担
     */
    private String fareBearer;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * (商家信息 1-易鑫自营)
     */
    private String businessType;

    /**
     * 联系人名称
     */
    private String contactName;

    /**
     * 联系方式(手机或邮箱)
     */
    private String contactStyle;

    /**
     * 备注
     */
    private String remark;


    /**
     * 商品状态 1-已上架，2-草稿，3-已下架
     */
    private String goodsStatus;

    /**
     * 上架时间
     */
    private Date upShelfDate;

    /**
     * 下架时间
     */
    private Date downShelfDate;

    /**
     * 位置索引
     */
    private Integer goodsIndex;
    /**
     * 商品图片
     */
    private List<GoodsImageSourceDTO>  goodsImages;
    /**
     *  销售地区
     */
    private GoodsSalePlaceDTO goodsSale;
    /**
     * 交互方式
     */
    private GoodsDeliveryModeDTO goodsDelivery;

    /**
     * 可销售地区
     */
    private List<GoodsSalePlaceDTO> goodsSaleDTOs;

    /**
     * 支持交货方式
     */
    private List<GoodsDeliveryModeDTO> goodsDeliveryDTOs;

    /**
     * 展示序号
     */
    private Integer sequence;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public List<GoodsSalePlaceDTO> getGoodsSaleDTOs() {
        return goodsSaleDTOs;
    }

    public void setGoodsSaleDTOs(List<GoodsSalePlaceDTO> goodsSaleDTOs) {
        this.goodsSaleDTOs = goodsSaleDTOs;
    }

    public List<GoodsDeliveryModeDTO> getGoodsDeliveryDTOs() {
        return goodsDeliveryDTOs;
    }

    public void setGoodsDeliveryDTOs(List<GoodsDeliveryModeDTO> goodsDeliveryDTOs) {
        this.goodsDeliveryDTOs = goodsDeliveryDTOs;
    }

    public String getCarMasterBrandId() {
        return carMasterBrandId;
    }

    public void setCarMasterBrandId(String carMasterBrandId) {
        this.carMasterBrandId = carMasterBrandId;
    }

    public String getCarMasterBrandName() {
        return carMasterBrandName;
    }

    public void setCarMasterBrandName(String carMasterBrandName) {
        this.carMasterBrandName = carMasterBrandName;
    }

    public String getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(String carBrandId) {
        this.carBrandId = carBrandId;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(String carModelId) {
        this.carModelId = carModelId;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarStyleId() {
        return carStyleId;
    }

    public void setCarStyleId(String carStyleId) {
        this.carStyleId = carStyleId;
    }

    public String getCarStyleName() {
        return carStyleName;
    }

    public void setCarStyleName(String carStyleName) {
        this.carStyleName = carStyleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getGarageCityCode() {
        return garageCityCode;
    }

    public void setGarageCityCode(String garageCityCode) {
        this.garageCityCode = garageCityCode;
    }

    public String getGarageCityName() {
        return garageCityName;
    }

    public void setGarageCityName(String garageCityName) {
        this.garageCityName = garageCityName;
    }

    public String getFormalities() {
        return formalities;
    }

    public void setFormalities(String formalities) {
        this.formalities = formalities;
    }

    public String getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(String guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentCommission() {
        return paymentCommission;
    }

    public void setPaymentCommission(String paymentCommission) {
        this.paymentCommission = paymentCommission;
    }

    public String getDepositRatio() {
        return depositRatio;
    }

    public void setDepositRatio(String depositRatio) {
        this.depositRatio = depositRatio;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getFareBearer() {
        return fareBearer;
    }

    public void setFareBearer(String fareBearer) {
        this.fareBearer = fareBearer;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactStyle() {
        return contactStyle;
    }

    public void setContactStyle(String contactStyle) {
        this.contactStyle = contactStyle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Date getUpShelfDate() {
        return upShelfDate;
    }

    public void setUpShelfDate(Date upShelfDate) {
        this.upShelfDate = upShelfDate;
    }

    public Date getDownShelfDate() {
        return downShelfDate;
    }

    public void setDownShelfDate(Date downShelfDate) {
        this.downShelfDate = downShelfDate;
    }

    public Integer getGoodsIndex() {
        return goodsIndex;
    }

    public void setGoodsIndex(Integer goodsIndex) {
        this.goodsIndex = goodsIndex;
    }

    public List<GoodsImageSourceDTO> getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(List<GoodsImageSourceDTO> goodsImages) {
        this.goodsImages = goodsImages;
    }

    public GoodsSalePlaceDTO getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(GoodsSalePlaceDTO goodsSale) {
        this.goodsSale = goodsSale;
    }

    public GoodsDeliveryModeDTO getGoodsDelivery() {
        return goodsDelivery;
    }

    public void setGoodsDelivery(GoodsDeliveryModeDTO goodsDelivery) {
        this.goodsDelivery = goodsDelivery;
    }

    /*
     * 继承BaseDTO时，es保存会失败，所以把baseDTO里的属性放到这里，不继承baseDTO。es查询可正常使用
     */
    /**
     * id
     */
    private String id;

    /**
     * 鐗堟湰
     */
    private Integer version;

    /**
     * 鍒涘缓鏃堕棿
     */
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createTime; // 鍒涘缓鏃堕棿

    /**
     * 鍒涘缓浜�
     */
    private String creatorId;

    /**
     * 鍒涘缓浜哄悕绉�
     */
    private String creatorName;

    /**
     * 鍒涘缓浜烘墍鍦ㄩ儴闂�
     */
    private Long creatorDepartmentId;

    /**
     * 鍒涘缓浜烘墍鍦ㄩ儴闂ㄥ悕绉�
     */
    private String creatorDepartmentName;

    /**
     * 鏈�鍚庝慨鏀规椂闂�
     */
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updateTime; // 鏇存柊鏃堕棿

    /**
     * 鏈�鍚庝慨鏀逛汉
     */
    private String updatorId;

    /**
     * 鏈�鍚庝慨鏀逛汉鍚嶇О
     */
    private String updatorName;

    /**
     * 鏈�鍚庝慨鏀逛汉鎵�鍦ㄩ儴闂�
     */
    private Long updatorDepartmentId;

    /**
     * 鏈�鍚庝慨鏀逛汉鎵�鍦ㄩ儴闂ㄥ悕绉�
     */
    private String updatorDepartmentName;
    /**
     * 鍒嗛〉锛氬綋鍓嶉〉
     */
    private Integer current = 1;

    /**
     * 姣忛〉璁板綍鏁�
     */
    private Integer rowCount = 10;

    /**
     * 鍒犻櫎鏍囪瘑
     */
    private Boolean deleted = false;

    /**
     * 涓氬姟娴佹按鍙稩D
     */
    private String bzId;

    /**
     * 褰撳墠鐧诲綍鐢ㄦ埛
     */
    private YxCurrentUserDTO currentUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Long getCreatorDepartmentId() {
        return creatorDepartmentId;
    }

    public void setCreatorDepartmentId(Long creatorDepartmentId) {
        this.creatorDepartmentId = creatorDepartmentId;
    }

    public String getCreatorDepartmentName() {
        return creatorDepartmentName;
    }

    public void setCreatorDepartmentName(String creatorDepartmentName) {
        this.creatorDepartmentName = creatorDepartmentName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId;
    }

    public String getUpdatorName() {
        return updatorName;
    }

    public void setUpdatorName(String updatorName) {
        this.updatorName = updatorName;
    }

    public Long getUpdatorDepartmentId() {
        return updatorDepartmentId;
    }

    public void setUpdatorDepartmentId(Long updatorDepartmentId) {
        this.updatorDepartmentId = updatorDepartmentId;
    }

    public String getUpdatorDepartmentName() {
        return updatorDepartmentName;
    }

    public void setUpdatorDepartmentName(String updatorDepartmentName) {
        this.updatorDepartmentName = updatorDepartmentName;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public YxCurrentUserDTO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(YxCurrentUserDTO currentUser) {
        this.currentUser = currentUser;
    }

    public String getBzId() {
        return bzId;
    }

    public void setBzId(String bzId) {
        this.bzId = bzId;
    }
}
