package com.liyz.fallInLove.assembler.user;

import com.liyz.fallInLove.dto.user.BaUserInfoDTO;
import com.liyz.fallInLove.enerty.domain.user.BaUserInfoEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BaUserInfoAssembler extends BaseAssembler
{

    public static BaUserInfoDTO toDto(BaUserInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        BaUserInfoDTO dto = new BaUserInfoDTO();
        mapObj(entity, dto);
        return dto;
    }

  
    public static List<BaUserInfoDTO> toDTOs(List<BaUserInfoEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<BaUserInfoDTO> dtoList = new ArrayList<BaUserInfoDTO>(entityList.size());
        for (BaUserInfoEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    
    public static BaUserInfoEntity toEntity(BaUserInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        BaUserInfoEntity entity = new BaUserInfoEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
    *@param  CarDemoDTOs
    *@return List<CarDemo>
    *@author code generator
    */
    public static List<BaUserInfoEntity> toEntitys(List<BaUserInfoDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<BaUserInfoEntity> entityList = new ArrayList<BaUserInfoEntity>(dtoList.size());
        for (BaUserInfoDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
}