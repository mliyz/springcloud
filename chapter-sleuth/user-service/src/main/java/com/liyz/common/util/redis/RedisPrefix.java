package com.liyz.common.util.redis;

public interface RedisPrefix {
	/**
	 * root层级的前缀不可单独使用
	 */
	String BASE_PREFIX = "vehiclemart:";
	/**
	 * 上牌分公司数据前缀
	 */
	String REG_BRAN_COM = BASE_PREFIX+"regBranCom:";
}
