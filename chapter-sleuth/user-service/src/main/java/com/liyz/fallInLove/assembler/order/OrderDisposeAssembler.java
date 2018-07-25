package com.liyz.fallInLove.assembler.order;

import com.alibaba.fastjson.JSONObject;
import com.liyz.fallInLove.dto.order.OrderDisposeDTO;
import com.liyz.fallInLove.dto.order.OrderGoodsInfoDTO;
import com.liyz.fallInLove.dto.order.OrderVehicleExportDTO;
import com.liyz.fallInLove.enerty.domain.order.OrderEntity;
import com.liyz.fallInLove.enerty.domain.order.OrderGoodsInfoEntity;
import com.liyz.fallInLove.enums.*;
import com.liyz.fallInLove.enums.order.DeliveryModeEnum;
import com.yixin.common.system.util.BaseAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: OrderDisposeAssembler
 * @Description 订单处理转换类
 * @author  YixinCapital -- lizhongxin
 * @date  2018年6月7日 下午2:14:02
 *
 */
public class OrderDisposeAssembler extends BaseAssembler
{
	
	private final static Logger  logger  = LoggerFactory.getLogger(OrderDisposeAssembler.class);
	
    public static OrderDisposeDTO toDto(OrderEntity entity) {
        if (entity == null) {
            return null;
        }
        OrderDisposeDTO dto = new OrderDisposeDTO();
        mapObj(entity, dto);
        return dto;
    }

    public static List<OrderDisposeDTO> toDTOs(List<OrderEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<OrderDisposeDTO> dtoList = new ArrayList<>(entityList.size());
        for (OrderEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public static OrderEntity toEntity(OrderDisposeDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderEntity entity = new OrderEntity();
        mapObj(dto, entity);
        return entity;
    }

   
    public static List<OrderEntity> toEntitys(List<OrderDisposeDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<OrderEntity> entityList = new ArrayList<OrderEntity>(dtoList.size());
        for (OrderDisposeDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
    
    
    /**
     *
     * @Description: 将 OrderGoodsInfoEntity List 组装为 OrderDisposeDTO list
     * @param goodInfoList
     * @return List<OrderDisposeDTO>
     * @throws
     * @author YixinCapital -- lizhongxin
     *	       2018年6月4日 下午8:33:31
     */
    public static List<OrderDisposeDTO> orderGoodInfosToOrderDisposeDTO(List<OrderGoodsInfoEntity> goodInfoList){
    	if(goodInfoList==null || goodInfoList.isEmpty() ) {
    		return Collections.emptyList();
    	}
    	List<OrderDisposeDTO> orders = new ArrayList<>();
    	for(OrderGoodsInfoEntity goodInfo : goodInfoList) {
    		 OrderDisposeDTO orderDisposeDTO = toDto(goodInfo.getOrder());
    		 if(orderDisposeDTO == null) {
    			 break;
    		 }
    		 OrderGoodsInfoDTO goodsInfoDTO = OrderGoodsInfoAssembler.toDto(goodInfo);
    		 goodsInfoDTO.setVehicleType(VehicleTypeEnum.getName(goodsInfoDTO.getVehicleType()));//车辆类型
    		 goodsInfoDTO.setPaymentType(PaymentTypeEnum.getName(goodsInfoDTO.getPaymentType()));//交易方式
    		 goodsInfoDTO.setFormalities(FormallitiesEnum.getName(goodsInfoDTO.getFormalities()));//手续
    		 goodsInfoDTO.setInvoiceType(InvoiceTypeEnum.getNameBycode(goodsInfoDTO.getInvoiceType()));// 发票类型 1-增票、2-零售票
    		 goodsInfoDTO.setFareBearer("1".equals(goodsInfoDTO.getFareBearer())? "卖家承担":"买家承担");//运费承担方 1-卖家承担,2-买家承担
    		 orderDisposeDTO.setDeliveryModeType(DeliveryModeEnum.getModeName(orderDisposeDTO.getDeliveryModeType()));//交货方式 1-送货上门，2-当地4S店自提，3-买方物流
    		 orderDisposeDTO.setStatus(OrderDealEnum.getBussName(orderDisposeDTO.getStatus()));//
    		 orderDisposeDTO.setOrderGoodsInfoDTO(goodsInfoDTO);
    		 orders.add(orderDisposeDTO);
    	}
    	return orders;
    }
    
    public static OrderDisposeDTO toOrderdisposeDto(OrderEntity entity,OrderGoodsInfoEntity goodInfoEntity) {
        if (entity == null) {
            return null;
        }
        OrderDisposeDTO orderDisposeDTO = new OrderDisposeDTO();
        mapObj(entity, orderDisposeDTO);
        OrderGoodsInfoDTO goodsInfoDTO = OrderGoodsInfoAssembler.toDto(goodInfoEntity);
        if(goodsInfoDTO  != null) {
        	 goodsInfoDTO.setVehicleType(VehicleTypeEnum.getName(goodsInfoDTO.getVehicleType()));//车辆类型
    		 goodsInfoDTO.setPaymentType(PaymentTypeEnum.getName(goodsInfoDTO.getPaymentType()));//交易方式
    		 goodsInfoDTO.setFormalities(FormallitiesEnum.getName(goodsInfoDTO.getFormalities()));//手续
    		 goodsInfoDTO.setInvoiceType(InvoiceTypeEnum.getNameBycode(goodsInfoDTO.getInvoiceType()));// 发票类型 1-增票、2-零售票
    		 goodsInfoDTO.setFareBearer("1".equals(goodsInfoDTO.getFareBearer())? "卖家承担":"买家承担");//运费承担方 1-卖家承担,2-买家承担
        }
		orderDisposeDTO.setDeliveryModeType(DeliveryModeEnum.getModeName(orderDisposeDTO.getDeliveryModeType()));// 交货方式1-送货上门，2-当地4S店自提，3-买方物流
		orderDisposeDTO.setStatus(OrderDealEnum.getBussName(orderDisposeDTO.getStatus()));//
		orderDisposeDTO.setOrderGoodsInfoDTO(goodsInfoDTO);
        return orderDisposeDTO;
    }
    /**
     * @Description: 将接单信息组装到订单实体
     * @param orderEntity
     * @param orderDispose void
     * @throws
     * @author YixinCapital -- lizhongxin
     *	       2018年6月8日 上午10:27:25
     */
	public static void orderTakingBuild(OrderEntity orderEntity, OrderDisposeDTO orderDispose) {
		logger.info("组装前订单实体信息：{}, 入参orderDisposeDTO 信息：{}",
				JSONObject.toJSON(orderEntity), JSONObject.toJSON(orderDispose));
		mapObjWithoutNull(orderDispose, orderEntity);
		
		logger.info("组装后订单实体信息：{}",JSONObject.toJSON(orderEntity));
	}
	/**
	 * @Description: 组装
	 * @param list
	 * @return List<OrderVehicleExportDTO>
	 * @throws
	 * @author YixinCapital -- lizhongxin
	 *	       2018年6月12日 下午3:32:06
	 */
	public static List<OrderVehicleExportDTO> assembleDictName(List<OrderVehicleExportDTO> list){
		list.stream().forEach(one ->{
			one.setVehicleType(VehicleTypeEnum.getName(one.getVehicleType()));//车辆类型
			one.setPaymentType(PaymentTypeEnum.getName(one.getPaymentType()));//交易方式
			one.setFormalities(FormallitiesEnum.getName(one.getFormalities()));//手续
			one.setInvoiceType(InvoiceTypeEnum.getNameBycode(one.getInvoiceType()));// 发票类型 1-增票、2-零售票
			one.setFareBearer("1".equals(one.getFareBearer())? "卖家承担":"买家承担");//运费承担方 1-卖家承担,2-买家承担
			one.setDeliveryModeType(DeliveryModeEnum.getModeName(one.getDeliveryModeType()));//交货方式 1-送货上门，2-当地4S店自提，3-买方物流
			one.setStatus(OrderDealEnum.getBussName(one.getStatus()));//订单状态
		});
		return list;
	}
}
