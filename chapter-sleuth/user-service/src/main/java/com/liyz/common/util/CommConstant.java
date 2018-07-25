package com.liyz.common.util;

/**
 * 公用常量类
 * Package : com.yixin.vehiclemart.util
 *
 * @author YixinCapital -- lizhongxin
 *		   2017年10月18日 下午2:24:40
 *
 */
public class CommConstant {
	
	private CommConstant() {
	    throw new IllegalAccessError("Utility class");
	  }
	/**
	 * 已发布
	 */
	public static final String CONTENTS_STATUS_PUBLISHED = "1";
	/**
	 * 未发布
	 */
	public static final String CONTENTS_STATUS_UNPUBLISHED = "0";
	/**
	 * 未逻辑删除
	 */
	public static final String IS_DELETED_NO="0";
	/**
	 * 已经逻辑删除
	 */
	public static final String IS_DELETE_YES="1";
	
	/**
	 * DATE_FORMAT_COMM= "yyyy-MM-dd"
	 */
	public static final String DATE_FORMAT_COMM= "yyyy-MM-dd";
	/**
	 * yyyyMMdd:20170808
	 */
	public static final String DATE_FORMAT_SIMPLE= "yyyyMMdd";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATETIME_FORMAT_COMM= "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyyMMddHHmmss
	 */
	public static final String DATETIME_FORMAT_SIMPLE= "yyyyMMddHHmmss";
	/**
	 * yyyyMMdd HH:mm:ss
	 */
	public static final String DATETIME_FORMAT_SIMPLE_TIME= "yyyyMMdd HH:mm:ss";
	
	/**
	 * 渠道类别:分公司类别
	 */
	public static final String CHANNEL_MODEL_CODE_BRANCH="0353000000014";
	/**
	 * 渠道类别:体验店类别
	 */
	public static final String CHANNEL_MODEL_CODE_ESHOP="0353000000002";
	
	/**
	 * 默认显示10条数据
	 */
	public static final int PAGE_SIZE=10;
	
	/**
	 * 目录内
	 */
	public static final String CONTENT_TYPE_IN="in";
	/**
	 * 目录外
	 */
	public static final String CONTENT_TYPE_OUT="out";
	/**
	 * 车辆id类别：进销存车辆id
	 */
	public static final String CARIDTYPE_CARID = "CARID";
	/**
	 * 车辆id类别：进销存车架号
	 */
	public static final String CARIDTYPE_VIN ="VIN";
	/**
	 * 已确认上牌
	 */
	public static final String CONFIRM_ON_CARD="1";

	/**
	 * 正常状态
	 */
	public static final Integer NORMAL_STATUT=1;
	/**
	 * 异常状态或锁定状态或禁用状态等
	 */
	public static final Integer ERROR_STATUT=0;
	/**
	 * 密码最大重试次数
	 */
	public static final Integer PWD_RETRY_MAX=5;

	public static final String WATER_MARK_CONTENT="图片来源：淘开鑫";
}

