package com.liyz.fallInLove.assembler.goods;

import com.liyz.fallInLove.assembler.attachSource.AttachSourceAssembler;
import com.liyz.fallInLove.dto.goods.GoodsImageSourceDTO;
import com.liyz.fallInLove.enerty.domain.attach.AttachSourceEntity;
import com.liyz.fallInLove.enerty.domain.goods.GoodsImageSourceEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: GoodsImageSourceAssembler
 * @Description GoodsImageSource转换类
 * @author YixinCapital -- mjj
 * @date 2018年5月29日 上午11:00:48
 *
 */
public class GoodsImageSourceAssembler extends BaseAssembler {
    public static GoodsImageSourceDTO toDto(GoodsImageSourceEntity entity) {
        if (entity == null) {
            return null;
        }
        GoodsImageSourceDTO dto = new GoodsImageSourceDTO();
        mapObj(entity, dto);
        return dto;
    }

    public static List<GoodsImageSourceDTO> toDTOs(List<GoodsImageSourceEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<GoodsImageSourceDTO> dtoList = new ArrayList<GoodsImageSourceDTO>(entityList.size());
        for (GoodsImageSourceEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public static GoodsImageSourceEntity toEntity(GoodsImageSourceDTO dto) {
        if (dto == null) {
            return null;
        }
        GoodsImageSourceEntity entity = new GoodsImageSourceEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
     * @param dtoList
     * @return List<GoodsImageSourceEntity>
     * @author code generator
     */
    public static List<GoodsImageSourceEntity> toEntitys(List<GoodsImageSourceDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<GoodsImageSourceEntity> entityList = new ArrayList<GoodsImageSourceEntity>(dtoList.size());
        for (GoodsImageSourceDTO dto : dtoList) {
            AttachSourceEntity attachSourceEntity = AttachSourceAssembler.toEntity(dto.getAttachSourceDTO());
            GoodsImageSourceEntity goodsImageSourceEntity = toEntity(dto);
            goodsImageSourceEntity.setAttachSourceEntity(attachSourceEntity);
            entityList.add(goodsImageSourceEntity);
        }
        return entityList;
    }
}
