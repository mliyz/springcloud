package com.liyz.fallInLove.assembler.order;

import com.liyz.common.util.DateUtil;
import com.liyz.common.util.ValidatorUtil;
import com.liyz.fallInLove.dto.order.OrderDTO;
import com.liyz.fallInLove.dto.order.OrderGoodsInfoDTO;
import com.liyz.fallInLove.enerty.domain.order.OrderEntity;
import com.liyz.fallInLove.enerty.domain.order.OrderGoodsInfoEntity;
import com.liyz.fallInLove.enums.*;
import com.liyz.fallInLove.enums.order.DeliveryModeEnum;
import com.yixin.common.system.util.BaseAssembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @ClassName: OrderAssembler
 * @Description 主订单转换类
 * @author YixinCapital -- mjj
 * @date 2018年5月30日 下午5:23:12
 *
 */
public class OrderAssembler extends BaseAssembler
{
    public static OrderDTO toDto(OrderEntity entity) {
        if (entity == null) {
            return null;
        }
        OrderDTO dto = new OrderDTO();
        mapObj(entity, dto);
        return dto;
    }

    public static List<OrderDTO> toDTOs(List<OrderEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<OrderDTO> dtoList = new ArrayList<OrderDTO>(entityList.size());
        for (OrderEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public static OrderEntity toEntity(OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderEntity entity = new OrderEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
     * @param CarDemoDTOs
     * @return List<CarDemo>
     * @author code generator
     */
    public static List<OrderEntity> toEntitys(List<OrderDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<OrderEntity> entityList = new ArrayList<OrderEntity>(dtoList.size());
        for (OrderDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
    
    public static OrderDTO objectsToDTO(Object[] obj){
        OrderDTO order = new OrderDTO();
        OrderGoodsInfoDTO orderGoods = new OrderGoodsInfoDTO();
        if (!ValidatorUtil.isEmpty(obj[0])) {
            // 订单id
            order.setId((String)obj[0]);
        }
        if (!ValidatorUtil.isEmpty(obj[1])) {
            // 订单编号
            order.setOrderNo((String)obj[1]);
        }
        if (!ValidatorUtil.isEmpty(obj[2])) {
            // 车辆总数量
            order.setTotalQuantity((Integer)obj[2]);
        }
        if (!ValidatorUtil.isEmpty(obj[3])) {
            // 首付合计金额
            order.setStartTotalPrice((BigDecimal)obj[3]);
        }
        if (!ValidatorUtil.isEmpty(obj[3])) {
            // 首付合计金额
            order.setStartTotalPrice((BigDecimal)obj[3]);
        }
        if (!ValidatorUtil.isEmpty(obj[4])) {
            // 尾付合计金额
            order.setEndTotalPrice((BigDecimal)obj[4]);
        }
        if (!ValidatorUtil.isEmpty(obj[5])) {
            // 交货方式
            order.setDeliveryModeType(DeliveryModeEnum.getModeName((String)obj[5]));
        }
        if (!ValidatorUtil.isEmpty(obj[6])) {
            // 状态
            order.setStatus(OrderDealEnum.getBussName((String)obj[6]));
        }
        if (!ValidatorUtil.isEmpty(obj[7])) {
            // 支付返佣
            order.setPaymentCommission((BigDecimal)obj[7]);
        }
        if (!ValidatorUtil.isEmpty(obj[8])) {
            // 单价
            order.setUnitPrice((BigDecimal)obj[8]);
        }
        if (!ValidatorUtil.isEmpty(obj[9])) {
            // 主品牌ID
            orderGoods.setCarMasterBrandId((String)obj[9]);
        }
        if (!ValidatorUtil.isEmpty(obj[10])) {
            // 品牌id
            orderGoods.setCarBrandId((String)obj[10]);
        }
        if (!ValidatorUtil.isEmpty(obj[11])) {
            // 车型id
            orderGoods.setCarModelId((String)obj[11]);
        }
        if (!ValidatorUtil.isEmpty(obj[12])) {
            // 车款id
            orderGoods.setCarStyleId((String)obj[12]);
        }
        if (!ValidatorUtil.isEmpty(obj[13])) {
            // 主品牌名称
            orderGoods.setCarMasterBrandName((String)obj[13]);
        }
        if (!ValidatorUtil.isEmpty(obj[14])) {
            // 品牌名称
            orderGoods.setCarMasterBrandName((String)obj[14]);
        }
        if (!ValidatorUtil.isEmpty(obj[15])) {
            // 车型名称
            orderGoods.setCarModelName((String)obj[15]);
        }
        if (!ValidatorUtil.isEmpty(obj[16])) {
            // 车款名称
            orderGoods.setCarStyleName((String)obj[16]);
        }
        if (!ValidatorUtil.isEmpty(obj[17])) {
            // 车辆类型
            orderGoods.setVehicleType(VehicleTypeEnum.getName((String)obj[17]));
        }
        if (!ValidatorUtil.isEmpty(obj[18])) {
            // 车源所在地名称
            orderGoods.setGarageCityName((String)obj[18]);
        }
        if (!ValidatorUtil.isEmpty(obj[19])) {
            // 手续方式
            orderGoods.setFormalities(FormallitiesEnum.getName((String)obj[19]));
        }
        if (!ValidatorUtil.isEmpty(obj[20])) {
            // 指导价
            orderGoods.setGuidePrice((BigDecimal)obj[20]);
        }
        if (!ValidatorUtil.isEmpty(obj[21])) {
            // 折扣价
            orderGoods.setDiscountPrice((BigDecimal)obj[21]);
        }
        if (!ValidatorUtil.isEmpty(obj[22])) {
            // 售价
            orderGoods.setSellPrice((BigDecimal)obj[22]);
        }
        if (!ValidatorUtil.isEmpty(obj[23])) {
            // 付款方式
            orderGoods.setPaymentType(PaymentTypeEnum.getName((String)obj[23]));
        }
        if (!ValidatorUtil.isEmpty(obj[24])) {
            // 全款支付返佣金额
            orderGoods.setPaymentCommission((BigDecimal)obj[24]);
        }
//        if (!ValidatorUtil.isEmpty(obj[25])) {
//            // 定金支付返佣
//            orderGoods.setDepositPaymentCommission((BigDecimal)obj[25]);
//        }
        if (!ValidatorUtil.isEmpty(obj[26])) {
            // 付款方式
            orderGoods.setBusinessType(BusinessTypeEnum.getName((String)obj[26]));
        }
        if (!ValidatorUtil.isEmpty(obj[27])) {
            // 下单时间
            order.setSubmitTime(DateUtil.dateToString((Date)obj[27], DateUtil.DATE_FORMAT_WITH_SECOND));
        }
        order.setOrderGoodsInfoDTO(orderGoods);
        return order;
    }
    /**
     *
     * @Description: 将 OrderGoodsInfoEntity List 组装为 OrderDTO list
     * @param goodInfoList
     * @return List<OrderDTO>
     * @throws
     * @author YixinCapital -- lizhongxin
     *	       2018年6月4日 下午8:33:31
     */
    public static List<OrderDTO> orderGoodInfosToOrderDTO(List<OrderGoodsInfoEntity> goodInfoList){
    	if(goodInfoList==null || goodInfoList.isEmpty() ) {
    		return Collections.emptyList();
    	}
    	List<OrderDTO> orders = new ArrayList<>();
    	for(OrderGoodsInfoEntity goodInfo : goodInfoList) {
    		 OrderDTO orderDTO = toDto(goodInfo.getOrder());
    		 if(orderDTO == null) {
    			 break;
    		 }
    		 OrderGoodsInfoDTO goodsInfoDTO = OrderGoodsInfoAssembler.toDto(goodInfo);
    		 goodsInfoDTO.setVehicleType(VehicleTypeEnum.getName(goodsInfoDTO.getVehicleType()));//车辆类型
    		 goodsInfoDTO.setPaymentType(PaymentTypeEnum.getName(goodsInfoDTO.getPaymentType()));//交易方式
    		 goodsInfoDTO.setFormalities(FormallitiesEnum.getName(goodsInfoDTO.getFormalities()));//手续
    		 goodsInfoDTO.setInvoiceType(InvoiceTypeEnum.getNameBycode(goodsInfoDTO.getInvoiceType()));// 发票类型 1-增票、2-零售票
    		 goodsInfoDTO.setFareBearer("1".equals(goodsInfoDTO.getFareBearer())? "卖家承担":"买家承担");//运费承担方 1-卖家承担,2-买家承担
    		 orderDTO.setDeliveryModeType(DeliveryModeEnum.getModeName(orderDTO.getDeliveryModeType()));//交货方式 1-送货上门，2-当地4S店自提，3-买方物流
    		 orderDTO.setStatus(OrderDealEnum.getBussName(orderDTO.getStatus()));//
    		 orderDTO.setOrderGoodsInfoDTO(goodsInfoDTO);
    		 orders.add(orderDTO);
    	}
    	return orders;
    }
}
