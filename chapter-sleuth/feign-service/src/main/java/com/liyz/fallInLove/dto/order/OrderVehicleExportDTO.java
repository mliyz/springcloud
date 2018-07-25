package com.liyz.fallInLove.dto.order;

import com.yixin.common.utils.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: OrderVehicleExportDTO
 * @Description 订单处理导出DTO
 * @author YixinCapital -- lizhongxin
 * @date 2018年6月12日 上午9:29:10
 *
 */

public class OrderVehicleExportDTO extends BaseDTO
{

	private static final long serialVersionUID = 7914463274480097242L;

	/**
	 * 淘开鑫车辆tid
	 */
	private String tid;

	/**
	 * 车架号
	 */
	private String vin;

	/**
	 * 子订单编号
	 */
	private String childOrderNo;

	/**
	 * 下单颜色
	 */
	private String orderColorName;

	/**
	 * 进销存导入颜色
	 */
	private String vehicleColorName;

	/**
	 * 实际发车时间
	 */
	private Date actualDepartureDate;

	/**
	 * 预计接车时间
	 */
	private Date predictDate;

	/**
	 * 主订单编号
	 */
	private String orderNo;

	/**
	 * 品牌名称
	 */
	private String carBrandName;

	/**
	 * 车型名称
	 */
	private String carModelName;

	/**
	 * 车款名称
	 */
	private String carStyleName;

	/**
	 * 车辆类型：1-国产-现车，2-国产-期货，3-合资-现车，4-合资-期货，5-进口-现车，6-进口-期货
	 */

	private String vehicleType;
	/**
	 * 交易方式. 1-全款发车,2-定金发车
	 */
	private String paymentType;

	/**
	 * 指导价
	 */
	private BigDecimal guidePrice;

	/**
	 * 折扣价
	 */
	private BigDecimal discountPrice;

	/**
	 * 支付返佣
	 */
	private BigDecimal paymentCommission;

	/**
	 * 单价
	 */
	private BigDecimal unitPrice;

	/**
	 * 手续 1-随车，2-邮寄
	 */
	private String formalities;

	/**
	 * 车源所在地名称
	 */
	private String garageCityName;

	/**
	 * 发票类型 1-增票、2-零售票
	 */
	private String invoiceType;

	/**
	 * 运费承担方 1-卖家承担,2-买家承担
	 */
	private String fareBearer;

	/**
	 * 交货方式 1-送货上门，2-当地4S店自提，3-买方物流
	 */
	private String deliveryModeType;

	/**
	 * 下单时间
	 */
	private Date submitTime;

	/**
	 * 下单人
	 */
	private String submitUser;
	/**
	 * 公司名称
	 */
	private String companyName;

	/**
	 * 状态 0-待接单，1-待发车，2-待收车，3-已完成，4-已失效，5-已取消
	 */
	private String status;

	// 接车信息
	/**
	 * 车辆接收详细地址
	 */
	private String vehicleAddress;
	/**
	 * 车辆接收人名称
	 */
	private String vehicleAccepterName;
	/**
	 * 车辆接收人电话
	 */
	private String vehicleAccepterPhone;

	// 开票信息
	/**
	 * 开票名称
	 */
	private String invoiceName;
	/**
	 * 税务号
	 */
	private String taxCode;
	/**
	 * 单位地址
	 */
	private String companyAddress;
	/**
	 * 联系电话
	 */
	private String contactPhone;
	/**
	 * 开户银行名称
	 */
	private String bankName;
	/**
	 * 银行账号
	 */
	private String bankAccount;

	// 收票信息
	/**
	 * 发票接收详细地址
	 */
	private String invoiceAddress;
	/**
	 * 发票接收人名称
	 */
	private String invoiceAccepterName;
	/**
	 * 发票接收人电话
	 */
	private String invoiceAccepterPhone;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getChildOrderNo() {
		return childOrderNo;
	}

	public void setChildOrderNo(String childOrderNo) {
		this.childOrderNo = childOrderNo;
	}

	public String getOrderColorName() {
		return orderColorName;
	}

	public void setOrderColorName(String orderColorName) {
		this.orderColorName = orderColorName;
	}

	public String getVehicleColorName() {
		return vehicleColorName;
	}

	public void setVehicleColorName(String vehicleColorName) {
		this.vehicleColorName = vehicleColorName;
	}

	public Date getActualDepartureDate() {
		return actualDepartureDate;
	}

	public void setActualDepartureDate(Date actualDepartureDate) {
		this.actualDepartureDate = actualDepartureDate;
	}

	public Date getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(Date predictDate) {
		this.predictDate = predictDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCarBrandName() {
		return carBrandName;
	}

	public void setCarBrandName(String carBrandName) {
		this.carBrandName = carBrandName;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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

	public BigDecimal getPaymentCommission() {
		return paymentCommission;
	}

	public void setPaymentCommission(BigDecimal paymentCommission) {
		this.paymentCommission = paymentCommission;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getFormalities() {
		return formalities;
	}

	public void setFormalities(String formalities) {
		this.formalities = formalities;
	}

	public String getGarageCityName() {
		return garageCityName;
	}

	public void setGarageCityName(String garageCityName) {
		this.garageCityName = garageCityName;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getFareBearer() {
		return fareBearer;
	}

	public void setFareBearer(String fareBearer) {
		this.fareBearer = fareBearer;
	}

	public String getDeliveryModeType() {
		return deliveryModeType;
	}

	public void setDeliveryModeType(String deliveryModeType) {
		this.deliveryModeType = deliveryModeType;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getSubmitUser() {
		return submitUser;
	}

	public void setSubmitUser(String submitUser) {
		this.submitUser = submitUser;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVehicleAddress() {
		return vehicleAddress;
	}

	public void setVehicleAddress(String vehicleAddress) {
		this.vehicleAddress = vehicleAddress;
	}

	public String getVehicleAccepterName() {
		return vehicleAccepterName;
	}

	public void setVehicleAccepterName(String vehicleAccepterName) {
		this.vehicleAccepterName = vehicleAccepterName;
	}

	public String getVehicleAccepterPhone() {
		return vehicleAccepterPhone;
	}

	public void setVehicleAccepterPhone(String vehicleAccepterPhone) {
		this.vehicleAccepterPhone = vehicleAccepterPhone;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	public String getInvoiceAccepterName() {
		return invoiceAccepterName;
	}

	public void setInvoiceAccepterName(String invoiceAccepterName) {
		this.invoiceAccepterName = invoiceAccepterName;
	}

	public String getInvoiceAccepterPhone() {
		return invoiceAccepterPhone;
	}

	public void setInvoiceAccepterPhone(String invoiceAccepterPhone) {
		this.invoiceAccepterPhone = invoiceAccepterPhone;
	}

}
