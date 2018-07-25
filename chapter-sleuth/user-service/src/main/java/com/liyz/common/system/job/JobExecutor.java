package com.liyz.common.system.job;

import com.yixin.common.utils.JobParamDTO;

/**
 * 任务调度
 *
 * Package : com.yixin.common.system.job
 *
 * @author YixinCapital -- wujt 2016年8月12日 上午9:13:02
 *
 */
public interface JobExecutor {

	/**
	 * 执行调度任务
	 *
	 * @param jobParamDTO
	 * @return
	 * @author YixinCapital -- wujt 2016年8月12日 下午3:52:47
	 */
	JobParamDTO execute(JobParamDTO jobParamDTO);

}
