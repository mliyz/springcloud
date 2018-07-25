package com.liyz.fallInLove.assembler.user;

import com.liyz.fallInLove.dto.user.BaPwdRestDTO;
import com.liyz.fallInLove.enerty.domain.user.BaIdentifyCodeEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaPwdRestAssembler extends BaseAssembler
{

    public static BaPwdRestDTO toDto(BaIdentifyCodeEntity entity){
        if (entity == null) {
            return null;
        }
        BaPwdRestDTO dto = new BaPwdRestDTO();
        mapObj(entity, dto);
        return dto;
    }
    public static List<BaPwdRestDTO> toDTOs(List<BaIdentifyCodeEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<BaPwdRestDTO> dtoList = new ArrayList<BaPwdRestDTO>(entityList.size());
        for (BaIdentifyCodeEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }


    public static BaIdentifyCodeEntity toEntity(BaPwdRestDTO dto) {
        if (dto == null) {
            return null;
        }
        BaIdentifyCodeEntity entity = new BaIdentifyCodeEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
     *@param
     *@return List<BaIdentifyCodeEntity>
     *@author code generator
     */
    public static List<BaIdentifyCodeEntity> toEntitys(List<BaPwdRestDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<BaIdentifyCodeEntity> entityList = new ArrayList<BaIdentifyCodeEntity>(dtoList.size());
        for (BaPwdRestDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
}
