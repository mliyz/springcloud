package com.liyz.fallInLove.assembler.goods;

import com.liyz.fallInLove.dto.goods.GoodsSalePlaceDTO;
import com.liyz.fallInLove.enerty.domain.goods.GoodsSalePlaceEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: GoodsSalePlaceAssembler
 * @Description GoodsSalePlace转换类
 * @author  YixinCapital --liyuzhang
 * @date  2018年5月29日 下午1:45:59
 *
 */
public class GoodsSalePlaceAssembler extends BaseAssembler
{
    public static GoodsSalePlaceDTO toDto(GoodsSalePlaceEntity entity) {
        if (entity == null) {
            return null;
        }
        GoodsSalePlaceDTO dto = new GoodsSalePlaceDTO();
        mapObj(entity, dto);
        return dto;
    }
    
    public static List<GoodsSalePlaceDTO> toDTOs(List<GoodsSalePlaceEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<GoodsSalePlaceDTO> dtoList = new ArrayList<GoodsSalePlaceDTO>(entityList.size());
        for (GoodsSalePlaceEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
    
    public static GoodsSalePlaceEntity toEntity(GoodsSalePlaceDTO dto) {
        if (dto == null) {
            return null;
        }
        GoodsSalePlaceEntity entity = new GoodsSalePlaceEntity();
        mapObj(dto, entity);
        return entity;
    }
    
    /**
     * @param
     * @return List<CarDemo>
     * @author code generator
     */
    public static List<GoodsSalePlaceEntity> toEntitys(List<GoodsSalePlaceDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<GoodsSalePlaceEntity> entityList = new ArrayList<GoodsSalePlaceEntity>(dtoList.size());
        for (GoodsSalePlaceDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

}
