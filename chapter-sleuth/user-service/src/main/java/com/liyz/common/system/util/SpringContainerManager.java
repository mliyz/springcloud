package com.liyz.common.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 *
 * Package ：com.yixin.common.system.util
 *
 * @author YixinCapital--wujt 2017/7/10 11:27
 *
 */
@Component
public class SpringContainerManager implements DisposableBean {

	private static final Logger logger = LoggerFactory.getLogger(SpringContainerManager.class);

	@Override
	public void destroy() throws Exception {
		logger.info("SpringContainer stoping...");
		SpringKafkaConsumer.stopKafkaConsumer();
		logger.info("SpringContainer stoped!");
	}
}
