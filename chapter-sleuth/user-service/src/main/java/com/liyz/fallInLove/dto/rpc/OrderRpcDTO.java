package com.liyz.fallInLove.dto.rpc;

/**
 *
 * @ClassName: OrderRpcDTO
 * @Description 订单信息接口--进销存
 * @author YixinCapital -- mjj
 * @date 2018年6月6日 下午4:52:56
 *
 */
public class OrderRpcDTO {

    /**
     * 入参id
     */
    private String inputId;

    /**
     * 车款id
     */
    private String carStyleId;

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    public String getCarStyleId() {
        return carStyleId;
    }

    public void setCarStyleId(String carStyleId) {
        this.carStyleId = carStyleId;
    }

}

