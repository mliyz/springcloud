package com.liyz.fallInLove.enums;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @ClassName: OrderDealEnum
 * @Description 订单处理字段对应关系
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月22日 下午7:40:01
 *
 */
public enum OrderDealEnum {

    PLACE("ORDERPLACE","用户下单","0","待接单"),
    CONFIRMACCEPT("CONFIRMACCEPT","确认接单","1","待发车"),
    DEAL_SENDINGCAR("DEAL","处理订单信息","1","待发车"),
    DEAL("DEAL","处理订单信息","2","待收车"),
    IMPORT("IMPORT","导入车辆物流","2","待收车"),
    CONFIRMRECEIVE("CONFIRMRECEIVE","确认收车","3","已完成"),
    REFUSE("REFUSE","拒绝接单","4","已失效"),
    CANCEL("CANCEL","取消订单","5","已取消");

    private String typeCode;
    private String typeName;
    private String bussCode;
    private String bussName;

    OrderDealEnum(String typeCode, String typeName, String bussCode, String bussName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.bussCode = bussCode;
        this.bussName = bussName;
    }
    
    /**
     *
     * @Description: 根据code获取名称
     * @param bussCode
     * @return String
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月31日 上午11:00:13
     */
    public static String getBussName(String bussCode){
        if(StringUtils.isBlank(bussCode)){
            return null;
        }
        OrderDealEnum[] orderDealEnum = OrderDealEnum.values();
        for (OrderDealEnum temp : orderDealEnum) {
            if(temp.bussCode.equals(bussCode)){
                return temp.getBussName();
            }
        }
        return null;
    }
    /**
     *
     * @Description: 查询返还所有订单状态 code\name
     * @return Map<String,String>
     * @throws
     * @author YixinCapital -- lizhongxin
     *	       2018年6月7日 下午4:13:38
     */
    public static Map<String,String> getOrderStatus(){
    	Map<String,String> map = new HashMap<>();
    	for(OrderDealEnum temp : OrderDealEnum.values()) {
    		map.put(temp.getBussCode(), temp.getBussName());
    	}
    	return map;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getBussCode() {
        return bussCode;
    }

    public String getBussName() {
        return bussName;
    }
}
