package com.liyz.fallInLove.core;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;

/**
 * 汽车Demo
 */
//@Entity
public class CarDemo extends BZBaseEntiy
{

    private static final long serialVersionUID = 1L;
    /**
     * 车辆识别码(Vehicle Identification Number)
     */
    @Column
    private String vin;
    /**
     * 车牌号
     */
    @Column
    private String plateNumber;
    /**
     * 品牌
     */
    @Column
    private String brand;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
