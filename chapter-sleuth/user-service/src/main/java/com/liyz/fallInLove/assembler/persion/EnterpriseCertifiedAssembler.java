package com.liyz.fallInLove.assembler.persion;

import com.liyz.fallInLove.dto.person.EnterpriseCertifiedDTO;
import com.liyz.fallInLove.dto.verify.VerifyProcessCreateDTO;
import com.liyz.fallInLove.enerty.domain.person.EnterpriseCertifiedEntity;
import com.yixin.common.system.util.BaseAssembler;

/**
 * @ClassName: EnterpriseCertifiedAssembler
 * @Description EnterpriseCertified转换类
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月22日 下午3:48:05
 *
 */
public class EnterpriseCertifiedAssembler extends BaseAssembler
{

    /**
     * 实体转成DTO
     * @param entity
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月22日 下午3:39:57
     */
    public static EnterpriseCertifiedDTO toDto(EnterpriseCertifiedEntity entity) {
        if (entity == null) {
            return null;
        }
        EnterpriseCertifiedDTO dto = new EnterpriseCertifiedDTO();
        mapObj(entity, dto);
        return dto;
    }

    /**
     * 将DTO有值得属性赋值给实体类
     * @param dto
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月22日 下午3:39:57
     */
    public static void assignmentEntity(EnterpriseCertifiedDTO dto,EnterpriseCertifiedEntity entity) {
        if (dto == null) {
            return;
        }
        mapObjWithoutNull(dto, entity);
    }

    /**
     * DTO转成实体
     * @param dto
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月22日 下午3:39:57
     */
    public static EnterpriseCertifiedEntity toEntity(EnterpriseCertifiedDTO dto) {
        if (dto == null) {
            return null;
        }
        EnterpriseCertifiedEntity entity = new EnterpriseCertifiedEntity();
        mapObjWithoutNull(dto, entity);
        return entity;
    }

    /**
     * 企业认证DTO转成待办DTO
     * @param dto
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月31日 上午10:39:57
     */
    public static VerifyProcessCreateDTO toVerifyProcessCreateDTO(EnterpriseCertifiedDTO dto, String entityId){
        if (dto == null) {
            return null;
        }
        VerifyProcessCreateDTO verifyProcessCreateDTO = new VerifyProcessCreateDTO();
        //企业认证表id
        verifyProcessCreateDTO.setEnterpriseCertifyId(entityId);
        verifyProcessCreateDTO.setUserinfoId(dto.getUserinfoId());
        verifyProcessCreateDTO.setCompanyName(dto.getCompanyName());
        verifyProcessCreateDTO.setCompanyAddress(dto.getCompanyAddress());
        verifyProcessCreateDTO.setCertifiedType("2");
        return verifyProcessCreateDTO;
    }
}
