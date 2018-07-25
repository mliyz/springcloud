package com.liyz.fallInLove.assembler.order;

import com.liyz.fallInLove.dto.order.OrderVehicleItemDTO;
import com.liyz.fallInLove.enerty.domain.order.OrderVehicleItemEntity;
import com.liyz.fallInLove.enums.VehicleStatusEnum;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: OrderVehicleItemAssembler
 * @Description 子订单对应车辆转换类
 * @author YixinCapital -- yangfei02
 * @date 2018年5月30日 下午5:24:50
 *
 */
public class OrderVehicleItemAssembler extends BaseAssembler
{
    public static OrderVehicleItemDTO toDto(OrderVehicleItemEntity entity) {
        if (entity == null) {
            return null;
        }
        OrderVehicleItemDTO dto = new OrderVehicleItemDTO();
        mapObj(entity, dto);
        dto.setVehicleStatusStr(VehicleStatusEnum.getName(dto.getVehicleStatus()));
        return dto;
    }

    public static List<OrderVehicleItemDTO> toDTOs(List<OrderVehicleItemEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<OrderVehicleItemDTO> dtoList = new ArrayList<OrderVehicleItemDTO>(entityList.size());
        for (OrderVehicleItemEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
    
}
