package com.liyz.fallInLove.assembler.order;

import com.liyz.fallInLove.dto.goods.GoodsInfoDTO;
import com.liyz.fallInLove.dto.order.OrderGoodsInfoDTO;
import com.liyz.fallInLove.enerty.domain.order.OrderGoodsInfoEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: OrderGoodsInfoGoodsInfoAssembler
 * @Description 下单时的商品信息转换类
 * @author YixinCapital -- mjj
 * @date 2018年5月30日 下午6:36:36
 *
 */
public class OrderGoodsInfoAssembler extends BaseAssembler
{
    public static OrderGoodsInfoDTO toDto(OrderGoodsInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        OrderGoodsInfoDTO dto = new OrderGoodsInfoDTO();
        mapObj(entity, dto);
        return dto;
    }

    public static List<OrderGoodsInfoDTO> toDTOs(List<OrderGoodsInfoEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<OrderGoodsInfoDTO> dtoList = new ArrayList<OrderGoodsInfoDTO>(entityList.size());
        for (OrderGoodsInfoEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public static OrderGoodsInfoEntity toEntity(OrderGoodsInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderGoodsInfoEntity entity = new OrderGoodsInfoEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
     * @param CarDemoDTOs
     * @return List<CarDemo>
     * @author code generator
     */
    public static List<OrderGoodsInfoEntity> toEntitys(List<OrderGoodsInfoDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<OrderGoodsInfoEntity> entityList = new ArrayList<OrderGoodsInfoEntity>(dtoList.size());
        for (OrderGoodsInfoDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    /**
     *
     * @Description: 商品信息转换成下单时的商品信息
     * @param dto
     * @return OrderGoodsInfoEntity
     * @throws @author YixinCapital -- mjj 2018年5月30日 下午6:39:28
     */
    public static OrderGoodsInfoEntity toOrderGoodsInfoEntity(GoodsInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderGoodsInfoEntity entity = new OrderGoodsInfoEntity();
        mapObj(dto, entity);
        return entity;
    }

}
