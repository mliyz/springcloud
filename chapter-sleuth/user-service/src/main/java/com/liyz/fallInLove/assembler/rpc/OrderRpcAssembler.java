package com.liyz.fallInLove.assembler.rpc;


import com.liyz.fallInLove.dto.rpc.OrderRpcDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: OrderRpcAssembler
 * @Description 订单信息接口--进销存
 * @author YixinCapital -- mjj
 * @date 2018年6月6日 下午4:58:28
 *
 */
public class OrderRpcAssembler {
    /**
     *
     * @Description: 自定义转换DTO
     * @param dto
     * @return OrderGoodsInfoEntity
     * @throws @author YixinCapital -- mjj 2018年6月5日 下午5:42:29
     */
    public static List<OrderRpcDTO> toDtosByList(List<Object[]> list) {
        if (list == null) {
            return null;
        }
        List<OrderRpcDTO> dtoList = new ArrayList<OrderRpcDTO>();
        OrderRpcDTO orderRpcDTO = null;
        for (int i = 0; i < list.size(); i++) {
            orderRpcDTO = new OrderRpcDTO();
            if (list.get(i)[0] != null)
                orderRpcDTO.setInputId(list.get(i)[0].toString());
            if (list.get(i)[1] != null)
                orderRpcDTO.setCarStyleId(list.get(i)[1].toString());
            dtoList.add(orderRpcDTO);
        }
        return dtoList;
    }
}

