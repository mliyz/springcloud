package com.liyz.common.util;

/**
 * 定时任务调度状态
 *
 * Package : com.liyz.common.utils
 *
 */
public enum JobStatus
{

	executed(0, "已调度"), executing(1, "执行中"), execute_success(2, "执行成功"), execute_falied(3,
			"执行失败"), execute_exception(4, "执行过程异常");

	private int index;
	private String displayName;

	private JobStatus(int index, String displayName) {
		this.index = index;
		this.displayName = displayName;
	}

	public int getIndex() {
		return index;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static String getDisplayNameByIndex(int value) {
		for (JobStatus status : JobStatus.values()) {
			if (value == status.getIndex()) {
				return status.getDisplayName();
			}
		}
		return "";
	}

}
