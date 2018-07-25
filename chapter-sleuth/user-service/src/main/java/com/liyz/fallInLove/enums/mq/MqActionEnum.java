package com.liyz.fallInLove.enums.mq;
/**
 * rabbitmq 处理动作枚举
 * Package : com.yixin.vehiclemart.enums.mq
 *
 * @author YixinCapital -- lizhongxin
 *		   2018年1月18日 上午11:46:09
 *
 */
public enum MqActionEnum {

		  ACCEPT(),  // 处理成功
		  RETRY(),   // 可以重试的错误
		  REJECT();  // 无需重试的错误

}

