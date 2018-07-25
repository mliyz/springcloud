package com.liyz.fallInLove.assembler.address;

import com.google.gson.internal.LinkedTreeMap;
import com.liyz.fallInLove.dto.address.AddressDTO;
import com.yixin.common.exception.BzException;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: AddressAssembler
 * @Description 省市信息转换类
 * @author YixinCapital -- mjj
 * @date 2018年6月6日 下午1:58:35
 *
 */
public class AddressAssembler extends BaseAssembler
{

    /**
     *
     * @Description: object转换成List<AddressDTO>
     * @param obj
     * @return List<AddressDTO>
     * @throws @author YixinCapital -- mjj 2018年6月6日 下午3:30:22
     */
    @SuppressWarnings({ "unused" })
    public static List<AddressDTO> toDtos(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            List<AddressDTO> list = new ArrayList<AddressDTO>();
            AddressDTO dto = null;
            @SuppressWarnings("unchecked")
            List<LinkedTreeMap<String, Object>> tmp = (List<LinkedTreeMap<String, Object>>) obj;
            if (tmp != null) {
                for (LinkedTreeMap<String, Object> linkedTreeMap : tmp) {
                    dto = new AddressDTO();
                    if (linkedTreeMap.get("sid") != null)
                        dto.setSid(linkedTreeMap.get("sid").toString());
                    if (linkedTreeMap.get("stype") != null)
                        dto.setStype(linkedTreeMap.get("stype").toString());
                    if (linkedTreeMap.get("parentId") != null)
                        dto.setParentId(tmp.get(0).get("parentId").toString());
                    if (linkedTreeMap.get("name") != null)
                        dto.setName(linkedTreeMap.get("name").toString());
                    if (linkedTreeMap.get("spell") != null)
                        dto.setSpell(linkedTreeMap.get("spell").toString());
                    if (linkedTreeMap.get("fullName") != null)
                        dto.setFullName(linkedTreeMap.get("fullName").toString());
                    if (linkedTreeMap.get("level") != null)
                        dto.setLevel(tmp.get(0).get("level").toString());
                    if (linkedTreeMap.get("orderNumber") != null)
                        dto.setOrderNumber(linkedTreeMap.get("orderNumber").toString());
                    if (linkedTreeMap.get("regionId") != null)
                        dto.setRegionId(linkedTreeMap.get("regionId").toString());
                    if (linkedTreeMap.get("spellFirst") != null)
                        dto.setSpellFirst(linkedTreeMap.get("spellFirst").toString());
                    list.add(dto);
                }
                return list;
            } else {
                throw new BzException("省市信息DTO转换异常");
            }

        } catch (Exception e) {
            throw new BzException("省市信息DTO转换异常", e);
        }
    }
}

