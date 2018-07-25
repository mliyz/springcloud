package com.liyz.fallInLove.dto.home;

import com.yixin.common.utils.BaseDTO;

/**
 *
 * @ClassName: HomeSearchDto
 * @Description 首页查询条件
 * @author  YixinCapital -- liyuzhang
 * @date  2018年5月30日 下午3:45:03
 *
 */
public class HomeSearchDto extends BaseDTO
{
	
	private static final long serialVersionUID = -5638589968706343557L;
	
	/**
	 * 用户手机号
	 */
	private String phone;
	
	/**
	 * 显示条数
	 */
	private String total;
	
	/**
	 * 一键找车（名称，颜色，价格，配置……）
	 */
	private String searchName;
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
	 * 排序字段
	 */
	private String orderName;
	/**
	 * 排序类型 asc  desc
	 */
	private String ordinalType;
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getTotal() {
		return total;
	}
	
	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getSearchName() {
		return searchName;
	}
	
	public void setSearchName(String searchName) {
		this.searchName = searchName;
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
	
	public String getOrderName() {
		return orderName;
	}
	
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public String getOrdinalType() {
		return ordinalType;
	}
	
	public void setOrdinalType(String ordinalType) {
		this.ordinalType = ordinalType;
	}
}
