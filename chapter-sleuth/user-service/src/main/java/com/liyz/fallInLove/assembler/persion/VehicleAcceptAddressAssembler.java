package com.liyz.fallInLove.assembler.persion;

import com.liyz.fallInLove.dto.person.VehicleAcceptAddressDto;
import com.liyz.fallInLove.enerty.domain.person.VehicleAcceptAddressEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @ClassName: VehicleAcceptAddressAssembler
 * @Description VehicleAcceptAddressDto转换类
 * @author  YixinCapital -- liyuzhang
 * @date  2018年5月21日 下午5:48:03
 *
 */

public class VehicleAcceptAddressAssembler extends BaseAssembler
{


    public static VehicleAcceptAddressDto toDto(VehicleAcceptAddressEntity entity) {
        if (entity == null) {
            return null;
        }
        VehicleAcceptAddressDto dto = new VehicleAcceptAddressDto();
        mapObj(entity, dto);
        return dto;
    }


    public static List<VehicleAcceptAddressDto> toDTOs(List<VehicleAcceptAddressEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<VehicleAcceptAddressDto> dtoList = new ArrayList<VehicleAcceptAddressDto>(entityList.size());
        for (VehicleAcceptAddressEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }


    public static VehicleAcceptAddressEntity toEntity(VehicleAcceptAddressDto dto) {
        if (dto == null) {
            return null;
        }
        VehicleAcceptAddressEntity entity = new VehicleAcceptAddressEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
     *@param dtoList
     *@return List<VehicleAcceptAddressEntity>
     *@author code generator
     */
    public static List<VehicleAcceptAddressEntity> toEntitys(List<VehicleAcceptAddressDto> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<VehicleAcceptAddressEntity> entityList = new ArrayList<VehicleAcceptAddressEntity>(dtoList.size());
        for (VehicleAcceptAddressDto dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
}
