package com.liyz.fallInLove.enerty.domain.goods;


import com.liyz.fallInLove.enerty.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @ClassName: GoodsInfoEntity
 * @Description 商品信息表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 上午10:45:03
 *
 */
@Entity
@Table(name = "ba_goods_info")
public class GoodsInfoEntity extends BZBaseEntiy
{

    private static final long serialVersionUID = 8882146642383365437L;

    /**
     * 主品牌ID
     */
    @Column(name = "car_master_brand_id",length = 50)
    private String carMasterBrandId;

    /**
     * 主品牌名称
     */
    @Column(name = "car_master_brand_name",length = 50)
    private String carMasterBrandName;

    /**
     * 品牌id
     */
    @Column(name = "car_brand_id",length = 50)
    private String carBrandId;

    /**
     * 品牌名称
     */
    @Column(name = "car_brand_name",length = 50)
    private String carBrandName;

    /**
     * 车型id
     */
    @Column(name = "car_model_id",length = 50)
    private String carModelId;

    /**
     * 车型名称
     */
    @Column(name = "car_model_name",length = 50)
    private String carModelName;

    /**
     * 车款id
     */
    @Column(name = "car_style_id",length = 50)
    private String carStyleId;

    /**
     * 车款名称
     */
    @Column(name = "car_style_name",length = 50)
    private String carStyleName;

    /**
     * 车辆类型：1-国产-现车，2-国产-期货，3-合资-现车，4-合资-期货，5-进口-现车，6-进口-期货
     */
    @Column(name = "vehicle_type",length = 10)
    private String vehicleType;

    /**
     * 车源所在地编号
     */
    @Column(name = "garage_city_code",length = 10)
    private String garageCityCode;

    /**
     * 车源所在地名称
     */
    @Column(name = "garage_city_name",length = 125)
    private String garageCityName;

    /**
     * 手续 1-随车，2-邮寄
     */
    @Column(name = "formalities",length = 10)
    private String formalities;

    /**
     * 指导价
     */
    @Column(name = "guide_price")
    private BigDecimal guidePrice;

    /**
     * 折扣价
     */
    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    /**
     * 售价
     */
    @Column(name = "sell_price")
    private BigDecimal sellPrice;

    /**
     * 交易方式. 1-全款发车,2-定金发车
     */
    @Column(name = "payment_type",length = 10)
    private String paymentType;

    /**
     * 支付返佣金额
     */
    @Column(name = "payment_commission")
    private BigDecimal paymentCommission;

    /**
     * 定金比例
     */
    @Column(name = "deposit_ratio")
    private BigDecimal depositRatio;

    /**
     * 发票类型 1-增票、2-零售票
     */
    @Column(name = "invoice_type",length = 10)
    private String invoiceType;

    /**
     * 起订台数
     */
    @Column(name = "min_quantity")
    private Integer minQuantity;

    /**
     * 发车时间
     */
    @Column(name = "departure_time")
    private Date departureTime;

    /**
     * 运费承担方 1-卖家承担,2-买家承担
     */
    @Column(name = "fare_bearer",length = 10)
    private String fareBearer;

    /**
     * 发布时间
     */
    @Column(name = "release_time")
    private Date releaseTime;

    /**
     * (商家信息 1-易鑫自营)
     */
    @Column(name = "business_type",length = 10)
    private String businessType;

    /**
     * 联系人名称
     */
    @Column(name = "contact_name",length = 50)
    private String contactName;

    /**
     * 联系方式(手机或邮箱)
     */
    @Column(name = "contact_style",length = 50)
    private String contactStyle;

    /**
     * 备注
     */
    @Column(name = "remark",length = 500)
    private String remark;


    /**
     * 商品状态 1-已上架，2-草稿，3-已下架
     */
    @Column(name = "goods_status",length = 10)
    private String goodsStatus="2";

    /**
     * 上架时间
     */
    @Column(name = "up_shelf_date")
    private Date upShelfDate;

    /**
     * 下架时间
     */
    @Column(name = "down_shelf_date")
    private Date downShelfDate;

    /**
     * 位置索引
     */
    @Column(name = "goods_index")
    private Integer goodsIndex=1000 ;

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

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPaymentCommission() {
        return paymentCommission;
    }

    public void setPaymentCommission(BigDecimal paymentCommission) {
        this.paymentCommission = paymentCommission;
    }

    public BigDecimal getDepositRatio() {
        return depositRatio;
    }

    public void setDepositRatio(BigDecimal depositRatio) {
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
}
