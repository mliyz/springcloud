package com.liyz.fallInLove.enerty.domain.order;

import com.yixin.common.system.domain.BZBaseEntiy;
import com.yixin.common.system.domain.BaseEntity;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

/**
 *
 * @ClassName: orderVehicleItemEntity
 * @Description 子订单对应的车辆信息表
 * @author YixinCapital -- lianghaoguan
 * @date 2018年5月28日 下午14:15:03
 *
 */
@Entity
@Table(name = "ba_order_vehicle_item")
public class OrderVehicleItemEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 8883248842385565437L;

    /**
     * 进销存车辆id
     */
    @Column(name = "vhicle_id", length = 50)
    private String vhicleId;

    /**
     * 车架号
     */
    @Column(name = "vin", length = 50)
    private String vin;

    /**
     * 预计接车时间
     */
    @Column(name = "predict_date")
    private Date predictDate;

    /**
     * 实际发车时间
     */
    @Column(name = "actual_departure_date")
    private Date actualDepartureDate;

    /**
     * 颜色
     */
    @Column(name = "color_name", length = 20)
    private String colorName;

    /**
     * 车辆状态 1-待发车，2-待收车，3-已确认收车
     */
    @Column(name = "vehicle_status", length = 10)
    private String vehicleStatus;

    /**
     * 子订单编号
     */
    @Column(name = "order_item_no", length = 50)
    private String orderItemNo;


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

    public static List<OrderVehicleItemEntity> findOrderVehicleItemsByOrderItemNo(String orderItemNo){
    	if(StringUtils.isBlank(orderItemNo)) {
    		return Collections.emptyList();
    	}
    	Map<String,Object> propValues = new HashMap<>();
    	propValues.put("orderItemNo", orderItemNo);
    	propValues.put("deleted", false);
    	return BaseEntity.findByProperties(OrderVehicleItemEntity.class, propValues);
    }
}
