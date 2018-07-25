package com.liyz.fallInLove.dto.mq;


import java.util.Date;


/**
 *
 * @ClassName: RentcarImportMqDTO
 * @Description 进销存车辆导入消息DTO
 * @author  YixinCapital -- lizhongxin
 * @date  2018年6月11日 下午4:44:55
 *
 */
public class RentcarImportMqDTO{

	/**
	 * 车辆id
	 */
	private String id;

	/**
	 * 车架号
	 */
	private String vin;

	/**
	 * 车牌号
	 */
	private String licNum;

	/**
	 * 颜色
	 */
	private String color;

	/**
	 * 所属分公司ID
	 */
	private String ownerOrgId;

	/**
	 * 所属分公司名称
	 */
	private String ownerOrgName;

	/**
	 * 计划到达时间
	 */
	private Date planArriveTime;

	/**
	 * 车库地址
	 */
	private String garageAddresss;

	/**
	 * 起运时间
	 */
	private Date startTransportTime;

	/**
	 * 导入分配时间
	 */
	private Date importDate;

	/**
	 * 供应链ID
	 */
	private String gid;

	/**
	 * 实际入库时间（首次）
	 */
	private Date actualStorageTime;

	/**
	 * 采购编号
	 */
	private String billNum;

	/**
	 * 淘开心ID
	 */
	private String taoId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOwnerOrgId() {
		return ownerOrgId;
	}

	public void setOwnerOrgId(String ownerOrgId) {
		this.ownerOrgId = ownerOrgId;
	}

	public String getOwnerOrgName() {
		return ownerOrgName;
	}

	public void setOwnerOrgName(String ownerOrgName) {
		this.ownerOrgName = ownerOrgName;
	}

	public Date getPlanArriveTime() {
		return planArriveTime;
	}

	public void setPlanArriveTime(Date planArriveTime) {
		this.planArriveTime = planArriveTime;
	}

	public String getLicNum() {
		return licNum;
	}

	public void setLicNum(String licNum) {
		this.licNum = licNum;
	}

	public String getGarageAddresss() {
		return garageAddresss;
	}

	public void setGarageAddresss(String garageAddresss) {
		this.garageAddresss = garageAddresss;
	}

	public Date getStartTransportTime() {
		return startTransportTime;
	}

	public void setStartTransportTime(Date startTransportTime) {
		this.startTransportTime = startTransportTime;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getBillNum() {
		return billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public Date getActualStorageTime() {
		return actualStorageTime;
	}

	public void setActualStorageTime(Date actualStorageTime) {
		this.actualStorageTime = actualStorageTime;
	}

	public String getTaoId() {
		return taoId;
	}

	public void setTaoId(String taoId) {
		this.taoId = taoId;
	}


}