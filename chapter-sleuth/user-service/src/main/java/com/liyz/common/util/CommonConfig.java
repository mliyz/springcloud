package com.liyz.common.util;

/**
 * Created by lianghaoguan on 2017/11/2.
 */
public final class CommonConfig {
	/**
	 *  通用操作锁定标识   当前需要检查该标志的 操作
	 *  1.手动匹配，2.自动匹配，3.执行过滤（清空临时表数据并重新插入） ，4.提交过滤 （清空临时表数据并重新插入并将要过滤的数据删除状态置为true）
	 *  5.车辆指派，6.订单指派，7.以后可能的需要用到或者刷新可用车临时表数据的操作。
	 *  因为此四种动作都会执行删除车辆信息临时表或者使用车辆信息临时表数据的操作。
	 *  */
	public static final String COMMON_OPR_LOCK_FLAG_KEY = "common.opr.lock.flag.key";
    public static final String match_auto_time_key = "match.auto.time.key";
    public static final String submissionScheme = "match.submissionScheme.key";

    public static final String match_artificial_time_key = "match.artificial.time.key";

    public static final String predict_report_shop_key = "report.shop.%s";

    public static final String match_auto_starting = "match.auto.starting";
    public static final String cancel_vehicle_assignment = "cancelVehicleAssignment";
    public static final String submission_vehicle_assignment = "submissionVehicleAssignment";

    public static final String unbundle_order_key = "unbundle.order.%s";

    public static final String branch_company_key = "branch.company.%s";

    public static final String save_branch_company_key = "save.branch.company.key";

    public static final String cancel_vehicle_key = "cancel.vehicle.key";

    public static final String confirm_order_shop_key = "confirm.shop.%s";
}
