package com.liyz.fallInLove.enerty.domain.order;


import com.liyz.fallInLove.enerty.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @ClassName: OrdeEntity
 * @Description 主订单表
 * @author YixinCapital -- lianghaoguan
 * @date 2018年5月28日 下午14:15:03
 *
 */
@Entity
@Table(name = "ba_order")
public class OrderEntity extends BZBaseEntiy
{

    private static final long serialVersionUID = 8883248842383365437L;

    /**
     * 用户id
     */
    @Column(name = "userinfo_id", length = 50)
    private String userinfoId;

    /**
     * 主订单编号
     */
    @Column(name = "order_no", length = 50)
    private String orderNo;

    /**
     * 买家留言
     */
    @Column(name = "buyer_message")
    private String buyerMessage;

    /**
     * 车辆总数量
     */
    @Column(name = "total_quantity")
    private Integer totalQuantity;

    /**
     * 首付合计金额
     */
    @Column(name = "start_total_price")
    private BigDecimal startTotalPrice;

    /**
     * 尾付合计金额
     */
    @Column(name = "end_total_price")
    private BigDecimal endTotalPrice;

    /**
     * 交货方式 1-送货上门，2-当地4S店自提，3-买方物流
     */
    @Column(name = "delivery_mode_type", length = 10)
    private String deliveryModeType;

    /**
     * 状态 0-待接单，1-待发车，2-待收车，3-已完成，4-已失效，5-已取消
     */
    @Column(name = "status", length = 10)
    private String status;

    /**
     * 车辆接收人名称
     */
    @Column(name = "vehicle_accepter_name", length = 50)
    private String vehicleAccepterName;

    /**
     * 车辆接收详细地址
     */
    @Column(name = "vehicle_address")
    private String vehicleAddress;

    /**
     * 车辆接收地址邮政编号
     */
    @Column(name = "vehicle_post_code", length = 20)
    private String vehiclePostCode;

    /**
     * 车辆接收人电话
     */
    @Column(name = "vehicle_accepter_phone", length = 30)
    private String vehicleAccepterPhone;

    /**
     * 发票接收人名称
     */
    @Column(name = "invoice_accepter_name", length = 50)
    private String invoiceAccepterName;

    /**
     * 发票接收详细地址
     */
    @Column(name = "invoice_address")
    private String invoiceAddress;

    /**
     * 发票接收地址邮政编号
     */
    @Column(name = "invoice_post_code", length = 20)
    private String invoicePostCode;

    /**
     * 发票接收人电话
     */
    @Column(name = "invoice_accepter_phone", length = 30)
    private String invoiceAccepterPhone;

    /**
     * 开票名称
     */
    @Column(name = "invoice_name", length = 125)
    private String invoiceName;

    /**
     * 税务号
     */
    @Column(name = "tax_code", length = 125)
    private String taxCode;

    /**
     * 单位地址
     */
    @Column(name = "company_address", length = 125)
    private String companyAddress;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone", length = 11)
    private String contactPhone;

    /**
     * 开户银行名称
     */
    @Column(name = "bank_name", length = 125)
    private String bankName;

    /**
     * 银行账号
     */
    @Column(name = "bank_account", length = 125)
    private String bankAccount;

    /**
     * 备注
     */
    @Column(name = "approval_msg")
    private String approvalMsg;

    /**
     * 支付返佣
     */
    @Column(name = "payment_commission")
    private BigDecimal paymentCommission;

    /**
     * 单价
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    /**
     * 商品信息ID
     */
    @Column(name = "goodsinfo_id", length = 50)
    private String goodsinfoId;

    /**
     * 下单时的商品信息表id
     */
    @Column(name = "order_goods_info_id", length = 50)
    private String orderGoodsInfoId;

    /**
     * 下单时间
     */
    @Column(name = "submit_time")
    private Date submitTime;

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
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

    public String getGoodsinfoId() {
        return goodsinfoId;
    }

    public void setGoodsinfoId(String goodsinfoId) {
        this.goodsinfoId = goodsinfoId;
    }

    public String getOrderGoodsInfoId() {
        return orderGoodsInfoId;
    }

    public void setOrderGoodsInfoId(String orderGoodsInfoId) {
        this.orderGoodsInfoId = orderGoodsInfoId;
    }

    public BigDecimal getStartTotalPrice() {
        return startTotalPrice;
    }

    public void setStartTotalPrice(BigDecimal startTotalPrice) {
        this.startTotalPrice = startTotalPrice;
    }

    public BigDecimal getEndTotalPrice() {
        return endTotalPrice;
    }

    public void setEndTotalPrice(BigDecimal endTotalPrice) {
        this.endTotalPrice = endTotalPrice;
    }

    public String getDeliveryModeType() {
        return deliveryModeType;
    }

    public void setDeliveryModeType(String deliveryModeType) {
        this.deliveryModeType = deliveryModeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVehicleAccepterName() {
        return vehicleAccepterName;
    }

    public void setVehicleAccepterName(String vehicleAccepterName) {
        this.vehicleAccepterName = vehicleAccepterName;
    }

    public String getVehicleAddress() {
        return vehicleAddress;
    }

    public void setVehicleAddress(String vehicleAddress) {
        this.vehicleAddress = vehicleAddress;
    }

    public String getVehiclePostCode() {
        return vehiclePostCode;
    }

    public void setVehiclePostCode(String vehiclePostCode) {
        this.vehiclePostCode = vehiclePostCode;
    }

    public String getVehicleAccepterPhone() {
        return vehicleAccepterPhone;
    }

    public void setVehicleAccepterPhone(String vehicleAccepterPhone) {
        this.vehicleAccepterPhone = vehicleAccepterPhone;
    }

    public String getInvoiceAccepterName() {
        return invoiceAccepterName;
    }

    public void setInvoiceAccepterName(String invoiceAccepterName) {
        this.invoiceAccepterName = invoiceAccepterName;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public String getInvoicePostCode() {
        return invoicePostCode;
    }

    public void setInvoicePostCode(String invoicePostCode) {
        this.invoicePostCode = invoicePostCode;
    }

    public String getInvoiceAccepterPhone() {
        return invoiceAccepterPhone;
    }

    public void setInvoiceAccepterPhone(String invoiceAccepterPhone) {
        this.invoiceAccepterPhone = invoiceAccepterPhone;
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

    public String getApprovalMsg() {
        return approvalMsg;
    }

    public void setApprovalMsg(String approvalMsg) {
        this.approvalMsg = approvalMsg;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

}
