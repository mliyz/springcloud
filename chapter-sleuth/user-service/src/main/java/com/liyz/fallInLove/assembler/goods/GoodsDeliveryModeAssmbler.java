package com.liyz.fallInLove.assembler.goods;

import com.liyz.fallInLove.dto.goods.GoodsDeliveryModeDTO;
import com.liyz.fallInLove.enerty.domain.goods.GoodsDeliveryModeEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: GoodsDeliveryModeAssmbler
 * @Description GoodsDeliveryMode转换类
 * @author YixinCapital -- liyuzhang
 * @date 2018年5月29日 下午1:45:03
 *
 */

public class GoodsDeliveryModeAssmbler extends BaseAssembler
{
	public static GoodsDeliveryModeDTO toDto(GoodsDeliveryModeEntity entity) {
		if (entity == null) {
			return null;
		}
		GoodsDeliveryModeDTO dto = new GoodsDeliveryModeDTO();
		mapObj(entity, dto);
		return dto;
	}
	
	public static List<GoodsDeliveryModeDTO> toDTOs(List<GoodsDeliveryModeEntity> entityList) {
		if (entityList == null) {
			return Collections.emptyList();
		}
		List<GoodsDeliveryModeDTO> dtoList = new ArrayList<GoodsDeliveryModeDTO>(entityList.size());
		for (GoodsDeliveryModeEntity entity : entityList) {
			dtoList.add(toDto(entity));
		}
		return dtoList;
	}
	
	public static GoodsDeliveryModeEntity toEntity(GoodsDeliveryModeDTO dto) {
		if (dto == null) {
			return null;
		}
		GoodsDeliveryModeEntity entity = new GoodsDeliveryModeEntity();
		mapObj(dto, entity);
		return entity;
	}
	
	/**
	 * @param
	 * @return List<CarDemo>
	 * @author code generator
	 */
	public static List<GoodsDeliveryModeEntity> toEntitys(List<GoodsDeliveryModeDTO> dtoList) {
		if (dtoList == null) {
			return Collections.emptyList();
		}
		List<GoodsDeliveryModeEntity> entityList = new ArrayList<GoodsDeliveryModeEntity>(dtoList.size());
		for (GoodsDeliveryModeDTO dto : dtoList) {
			entityList.add(toEntity(dto));
		}
		return entityList;
	}
}
