package com.liyz.fallInLove.dto.order;

import com.yixin.common.utils.BaseDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description 订单处理DTO
 * @author YixinCapital -- lianghaoguan
 * @date 2018年5月28日 下午14:15:03
 *
 */
public class OrderDisposeDTO extends BaseDTO
{

	private static final long serialVersionUID = 8477916723712754039L;

	/**
     * 用户id
     */
    private String userinfoId;

    /**
     * 主订单编号
     */
    private String orderNo;

    /**
     * 买家留言
     */
    private String buyerMessage;

    /**
     * 车辆总数量
     */
    private Integer totalQuantity;

    /**
     * 首付合计金额
     */
    private BigDecimal startTotalPrice;

    /**
     * 尾付合计金额
     */
    private BigDecimal endTotalPrice;

    /**
     * 交货方式 1-送货上门，2-当地4S店自提，3-买方物流
     */
    private String deliveryModeType;

    /**
     * 状态 0-待接单，1-待发车，2-待收车，3-已完成，4-已失效，5-已取消
     */
    private String status;

    /**
     * 车辆接收人名称
     */
    private String vehicleAccepterName;

    /**
     * 车辆接收详细地址
     */
    private String vehicleAddress;

    /**
     * 车辆接收地址邮政编号
     */
    private String vehiclePostCode;

    /**
     * 车辆接收人电话
     */
    private String vehicleAccepterPhone;

    /**
     * 发票接收人名称
     */
    private String invoiceAccepterName;

    /**
     * 发票接收详细地址
     */
    private String invoiceAddress;

    /**
     * 发票接收地址邮政编号
     */
    private String invoicePostCode;

    /**
     * 发票接收人电话
     */
    private String invoiceAccepterPhone;

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

    /**
     * 备注
     */
    private String approvalMsg;

    /**
     * 支付返佣
     */
    private BigDecimal paymentCommission;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 商品信息ID
     */
    private String goodsinfoId;

    /**
     * 下单时的商品信息
     */
    private OrderGoodsInfoDTO orderGoodsInfoDTO;

    /**
     * 下单时间
     */
    private String submitTime;
    
    /**
     * 下单人
     */
    private String submitUser;
    /**
     * 公司名称
     */
    private String companyName;
    
    /**
     * 子订单列表
     */
    private List<OrderItemDTO> orderItemList ;
    /**
     * 订单车辆信息
     */
    private List<OrderVehicleItemDTO> orderVehicleItemList;
    
    

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

	public List<OrderItemDTO> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemDTO> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }


    public OrderGoodsInfoDTO getOrderGoodsInfoDTO() {
        return orderGoodsInfoDTO;
    }

    public void setOrderGoodsInfoDTO(OrderGoodsInfoDTO orderGoodsInfoDTO) {
        this.orderGoodsInfoDTO = orderGoodsInfoDTO;
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

	public List<OrderVehicleItemDTO> getOrderVehicleItemList() {
		return orderVehicleItemList;
	}

	public void setOrderVehicleItemList(List<OrderVehicleItemDTO> orderVehicleItemList) {
		this.orderVehicleItemList = orderVehicleItemList;
	}
}
