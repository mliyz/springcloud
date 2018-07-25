package com.liyz.common.util.constant;
/**
 * 常量接口
 * @author lishuaifeng
 *
 */
public interface Constants {
	/**通用常量逻辑删除状态*/
	/**逻辑删除 ：1--已删除*/
	byte IS_DELETE_YES = 1;
	/**逻辑删除 ：0--未删除*/
	byte IS_DELETE_NO = 0;
	/* 订单子表提交匹配方案状态*****************************/
	/***提交匹配方案状态，状态0-- 未提交*/
	byte IS_CONFIRMED_NO = 0;
	/***提交匹配方案状态，状态1-- 已提交*/
	byte IS_CONFIRMED_YES = 1;
	
	/* 进销存可用车辆信息表（ec_vehicle_source_temp） 是否匹配字段常量值*/
	/** 匹配*/
	String CAR_METCH_YES = "1";
	/** 未匹配*/
	String CAR_METCH_NO = "0";
	
	/* 订单表order_status 状态值常量 ***********************************/
	/** 待确认*/
	byte ORDER_STATUS_WAIT_CONFIRM = 0;
	/** 已确认*/
	byte ORDER_STATUS_HAD_CONFIRM = 1;
	/** 放弃*/
	byte ORDER_STATUS_ABANDON = 2;
	
	/* 分公司区域表 level字段常量***********************************/
	/**级别，1--大区*/
	String LEVEL_REGION = "1";
	/**级别，2--分公司*/
	String LEVEL_ORG = "2";
	/** 下拉框全部 默认值 */
	int SELECT_ALL = -1;
	/**
	 * 邮件发送者
	 */
	String MAIL_FROM = "settle@yixincapital.com";
	/**
	 * 邮件接收人，多个用','隔开
	 */
	String MAIL_TO_PERSON="lizhongxin@yixincapital.com";
	/**
	 *保证金预警邮件标题
	 */
	String DEPOSIT_MAIL_TITLE="冻结/可用金额出现负数";
	/**
	 * 保证金预警邮件内容
	 */
	String DEPOSIT_MAIL_TEXT="体验店id:【%s】,名称：【%s】，冻结/可用保证金金额出现负数，请注意查看！";

}
