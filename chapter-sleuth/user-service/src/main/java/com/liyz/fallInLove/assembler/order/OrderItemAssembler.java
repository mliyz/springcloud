package com.liyz.fallInLove.assembler.order;

import com.liyz.fallInLove.dto.order.OrderItemDTO;
import com.liyz.fallInLove.enerty.domain.order.OrderItemEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: OrderItemAssembler
 * @Description 子订单转换类
 *
 */
public class OrderItemAssembler extends BaseAssembler
{
    public static OrderItemDTO toDto(OrderItemEntity entity) {
        if (entity == null) {
            return null;
        }
        OrderItemDTO dto = new OrderItemDTO();
        mapObj(entity, dto);
        return dto;
    }

    public static List<OrderItemDTO> toDTOs(List<OrderItemEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<OrderItemDTO> dtoList = new ArrayList<OrderItemDTO>(entityList.size());
        for (OrderItemEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public static OrderItemEntity toEntity(OrderItemDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderItemEntity entity = new OrderItemEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
     * @param CarDemoDTOs
     * @return List<CarDemo>
     * @author code generator
     */
    public static List<OrderItemEntity> toEntitys(List<OrderItemDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<OrderItemEntity> entityList = new ArrayList<OrderItemEntity>(dtoList.size());
        for (OrderItemDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
}
