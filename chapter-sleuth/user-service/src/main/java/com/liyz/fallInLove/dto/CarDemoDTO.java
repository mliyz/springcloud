package com.liyz.fallInLove.dto;

import com.yixin.common.utils.BaseDTO;

public class CarDemoDTO extends BaseDTO
{

	private static final long serialVersionUID = 1L;
	/**
     * 车辆识别码(Vehicle Identification Number)
     */
    private String vin;
    /**
     * 车牌号
     */
    private String plateNumber;
    /**
     * 品牌
     */
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

