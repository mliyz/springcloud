/**
 * Copyright © 2018 Yixin Info. Tech Ltd. All rights reserved.
 * @Title: VehicleInvoiceInfoAssembler.java
 * @Package com.yixin.vehiclemart.assembler.persion
 * @author mjj
 * @date 2018年5月21日 下午5:48:05
 * @version V1.0
 */
package com.liyz.fallInLove.assembler.persion;

import com.liyz.fallInLove.dto.person.VehicleInvoiceInfoDTO;
import com.liyz.fallInLove.enerty.domain.person.VehicleInvoiceInfoEntity;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @ClassName: VehicleInvoiceInfoAssembler
 * @Description VehicleInvoiceInfo转换类
 */
public class VehicleInvoiceInfoAssembler extends BaseAssembler
{
    public static VehicleInvoiceInfoDTO toDto(VehicleInvoiceInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        VehicleInvoiceInfoDTO dto = new VehicleInvoiceInfoDTO();
        mapObj(entity, dto);
        return dto;
    }

  
    public static List<VehicleInvoiceInfoDTO> toDTOs(List<VehicleInvoiceInfoEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<VehicleInvoiceInfoDTO> dtoList = new ArrayList<VehicleInvoiceInfoDTO>(entityList.size());
        for (VehicleInvoiceInfoEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    
    public static VehicleInvoiceInfoEntity toEntity(VehicleInvoiceInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        VehicleInvoiceInfoEntity entity = new VehicleInvoiceInfoEntity();
        mapObj(dto, entity);
        return entity;
    }

    /**
    *@param  CarDemoDTOs
    *@return List<CarDemo>
    *@author code generator
    */
    public static List<VehicleInvoiceInfoEntity> toEntitys(List<VehicleInvoiceInfoDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<VehicleInvoiceInfoEntity> entityList = new ArrayList<VehicleInvoiceInfoEntity>(dtoList.size());
        for (VehicleInvoiceInfoDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
}

