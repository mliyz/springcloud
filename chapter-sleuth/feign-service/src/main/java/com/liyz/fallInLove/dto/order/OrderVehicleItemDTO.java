package com.liyz.fallInLove.dto.order;

import com.liyz.fallInLove.dto.attach.AttachSourceDTO;
import com.yixin.common.utils.BaseDTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @ClassName: orderVehicleItemDTO
 * @Description 子订单对应的车辆信息DTO
 * @author YixinCapital -- lianghaoguan
 * @date 2018年5月28日 下午14:15:03
 *
 */
public class OrderVehicleItemDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883248842385565437L;

    /**
     * 进销存车辆id
     */
    private String vhicleId;

    /**
     * 车架号
     */
    private String vin;

    /**
     * 预计接车时间
     */
    private Date predictDate;

    /**
     * 实际发车时间
     */
    private Date actualDepartureDate;

    /**
     * 颜色
     */
    private String colorName;

    /**
     * 车辆状态 1-待发车，2-待收车，3-已确认收车
     */
    private String vehicleStatus;

    /**
     * 车辆状态 1-待发车，2-待收车，3-已确认收车
     */
    private String vehicleStatusStr;

    /**
     * 子订单编号
     */
    private String orderItemNo;

    /**
     * 车辆附件
     */
    private List<AttachSourceDTO> attachList;

    public String getVehicleStatusStr() {
        return vehicleStatusStr;
    }

    public void setVehicleStatusStr(String vehicleStatusStr) {
        this.vehicleStatusStr = vehicleStatusStr;
    }

    public List<AttachSourceDTO> getAttachList() {
        return attachList;
    }

    public void setAttachList(List<AttachSourceDTO> attachList) {
        this.attachList = attachList;
    }

    public String getVhicleId() {
        return vhicleId;
    }

    public void setVhicleId(String vhicleId) {
        this.vhicleId = vhicleId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getPredictDate() {
        return predictDate;
    }

    public void setPredictDate(Date predictDate) {
        this.predictDate = predictDate;
    }

    public Date getActualDepartureDate() {
        return actualDepartureDate;
    }

    public void setActualDepartureDate(Date actualDepartureDate) {
        this.actualDepartureDate = actualDepartureDate;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getOrderItemNo() {
        return orderItemNo;
    }

    public void setOrderItemNo(String orderItemNo) {
        this.orderItemNo = orderItemNo;
    }
}
