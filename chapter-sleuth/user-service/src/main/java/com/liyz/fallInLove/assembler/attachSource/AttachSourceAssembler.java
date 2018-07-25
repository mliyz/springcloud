package com.liyz.fallInLove.assembler.attachSource;

import com.liyz.fallInLove.dto.attach.AttachSourceDTO;
import com.liyz.fallInLove.dto.goods.GoodsInfoDTO;
import com.liyz.fallInLove.enerty.domain.attach.AttachSourceEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: AttachSourceAssembler
 * @Description 附件实体转换类
 * @author  YixinCapital -- yangfei02
 * @date  2018年6月1日 下午3:18:04
 *
 */
public class AttachSourceAssembler extends BaseAssembler
{
    public static AttachSourceDTO toDto(AttachSourceEntity entity) {
        if (entity == null) {
            return null;
        }
        AttachSourceDTO dto = new AttachSourceDTO();
        mapObj(entity, dto);
        return dto;
    }

    public static List<AttachSourceDTO> toDTOs(List<AttachSourceEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<AttachSourceDTO> dtoList = new ArrayList<AttachSourceDTO>(entityList.size());
        for (AttachSourceEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public static AttachSourceEntity toEntity(AttachSourceDTO dto) {
        if (dto == null) {
            return null;
        }
        AttachSourceEntity entity = new AttachSourceEntity();
        mapObj(dto, entity);
        return entity;
    }

    public static List<AttachSourceEntity> toEntitys(List<AttachSourceDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<AttachSourceEntity> entityList = new ArrayList<AttachSourceEntity>(dtoList.size());
        for (AttachSourceDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    public static AttachSourceEntity toAttachSourceEntity(GoodsInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        AttachSourceEntity entity = new AttachSourceEntity();
        mapObj(dto, entity);
        return entity;
    }
}
