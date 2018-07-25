package com.liyz.fallInLove.assembler.backstage;

import com.liyz.fallInLove.dto.backstage.UserMangerDTO;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lianghaoguan on 2018/5/22.
 * 用户管理 转换类
 */
public class UserMangerAssembler extends BaseAssembler
{

    /**
     * 将数据库查询结果转换成DTO
     * @param objArrys
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月22日 下午7:39:57
     */
    public static List<UserMangerDTO> toUserMangerDTOs(List<Object[]> objArrys) {
        if(objArrys == null) {
            return null;
        }

        List<UserMangerDTO> result = new ArrayList<>();
        for (Object[] object : objArrys) {
            UserMangerDTO dto = new UserMangerDTO();

            if(object[0] != null){
                dto.setId(String.valueOf(object[0]));
            }

            if(object[1] != null){
                dto.setRealName(String.valueOf(object[1]));
            }
            if(object[2] != null){
                dto.setCertifiedRealName(String.valueOf(object[2]));
            }
            if(object[3] != null){
                dto.setPhone(String.valueOf(object[3]));
            }
            if(object[4] != null){
                dto.setIdcard(String.valueOf(object[4]));
            }

            if(object[5] != null){
                dto.setWorkingPlace(String.valueOf(object[5]));
            }
            if(object[6] != null){
                dto.setQq(String.valueOf(object[6]));
            }

            if(object[7] != null){
                dto.setWechat(String.valueOf(object[7]));
            }
            if(object[8] != null){
                dto.setCustomerPosition(String.valueOf(object[8]));
            }

            if(object[9] != null){
                dto.setCompanyName(String.valueOf(object[9]));
            }
            if(object[10] != null){
                dto.setCompanyAddress(String.valueOf(object[10]));
            }
            result.add(dto);
        }

        return result;
    }
}
