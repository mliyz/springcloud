package com.liyz.fallInLove.assembler.persion;

import com.liyz.fallInLove.dto.person.PersonCertifiedDTO;
import com.liyz.fallInLove.enerty.domain.person.PersonCertifiedEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PersonCertifiedAssembler extends BaseAssembler
{

    public static PersonCertifiedDTO toDto(PersonCertifiedEntity entity) {
        if (entity == null) {
            return null;
        }
        PersonCertifiedDTO dto = new PersonCertifiedDTO();
        mapObj(entity, dto);
        return dto;
    }

  
    public static List<PersonCertifiedDTO> toDTOs(List<PersonCertifiedEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<PersonCertifiedDTO> dtoList = new ArrayList<PersonCertifiedDTO>(entityList.size());
        for (PersonCertifiedEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    
    public static PersonCertifiedEntity toEntity(PersonCertifiedDTO dto) {
        if (dto == null) {
            return null;
        }
        PersonCertifiedEntity entity = new PersonCertifiedEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
    *@param  CarDemoDTOs
    *@return List<CarDemo>
    *@author code generator
    */
    public static List<PersonCertifiedEntity> toEntitys(List<PersonCertifiedDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<PersonCertifiedEntity> entityList = new ArrayList<PersonCertifiedEntity>(dtoList.size());
        for (PersonCertifiedDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
}