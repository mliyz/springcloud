package com.liyz.fallInLove.assembler.logs;

import com.liyz.fallInLove.dto.logs.OperateLogDTO;
import com.liyz.fallInLove.enerty.domain.logs.OperateLogEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OperateLogAssembler extends BaseAssembler
{

    public static OperateLogDTO toDto(OperateLogEntity entity) {
        if (entity == null) {
            return null;
        }
        OperateLogDTO dto = new OperateLogDTO();
        mapObj(entity, dto);
        return dto;
    }

  
    public static List<OperateLogDTO> toDTOs(List<OperateLogEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<OperateLogDTO> dtoList = new ArrayList<OperateLogDTO>(entityList.size());
        for (OperateLogEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    
    public static OperateLogEntity toEntity(OperateLogDTO dto) {
        if (dto == null) {
            return null;
        }
        OperateLogEntity entity = new OperateLogEntity();
        mapObj(dto, entity);
        return entity;
    }

    public static List<OperateLogEntity> toEntitys(List<OperateLogDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<OperateLogEntity> entityList = new ArrayList<OperateLogEntity>(dtoList.size());
        for (OperateLogDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
}