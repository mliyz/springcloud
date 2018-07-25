package com.liyz.fallInLove.web.persion;

import com.liyz.common.util.JacksonUtil;
import com.liyz.common.util.ResultUtil;
import com.liyz.fallInLove.dto.person.VehicleAcceptAddressDto;
import com.liyz.fallInLove.service.persion.VehicleAcceptAddressService;
import com.yixin.common.exception.BzException;
import com.yixin.common.utils.InvokeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: VehicleAcceptAddressController
 * @Description 用户接收地址维护
 * @author  YixinCapital -- liyuzhang
 * @date  2018年5月21日 下午5:45:03
 *
 */
@RestController
@RequestMapping("/persion/address")
public class VehicleAcceptAddressController {
    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleAcceptAddressController.class);
    @Autowired
    VehicleAcceptAddressService vehicleAcceptAddressService;
    /**
     * @Description:用户接车信息添加
     * @param  vehicleAcceptAddressDto
     * @return InvokeResult<String> addVehicleAcceptAddress
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 16:16
    */
    @SuppressWarnings("unchecked")
    @PostMapping("/addVehicleAcceptAddress")
    InvokeResult<String> addVehicleAcceptAddress(@RequestBody VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException
    {
        LOGGER.info("用户接车信息添加：{}", JacksonUtil.fromObjectToJson(vehicleAcceptAddressDto));
        try {
             vehicleAcceptAddressService.addVehicleAcceptAddress(vehicleAcceptAddressDto);
        } catch (Exception e) {
            LOGGER.error("用户接车信息添加异常：【{}】", e.getMessage(), e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("用户接车信息添加成功");
    }
    /**
     * @Description:用户修改接车地址信息
     * @param  vehicleAcceptAddressDto
     * @return InvokeResult<String> updateVehicleAcceptAddress
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 16:17
    */
    @SuppressWarnings("unchecked")
    @PostMapping("/updateVehicleAcceptAddress")
    InvokeResult<String> updateVehicleAcceptAddress(@RequestBody VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException
    {
        LOGGER.info("用户接车信息修改：{}", JacksonUtil.fromObjectToJson(vehicleAcceptAddressDto));
        try {
            vehicleAcceptAddressService.updateVehicleAcceptAddress(vehicleAcceptAddressDto);
        } catch (Exception e) {
            LOGGER.error("用户接车信息修改异常：【{}】", e.getMessage(), e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("用户接车信息修改成功");
    }
    /**
     * @Description:删除用户接车地址
     * @param vehicleInvoiceInfoDTO
     * @return InvokeResult<String>
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 16:18
    */
    @SuppressWarnings("unchecked")
    @PostMapping("/deleteVehicleAcceptAddress")
    public InvokeResult<String> deleteVehicleAcceptAddress(@RequestBody VehicleAcceptAddressDto vehicleInvoiceInfoDTO){
        LOGGER.info("用户接车信息删除：{}", JacksonUtil.fromObjectToJson(vehicleInvoiceInfoDTO));
        try {
             vehicleAcceptAddressService.deleteVehicleAcceptAddress(vehicleInvoiceInfoDTO);
        } catch (Exception e) {
            LOGGER.error("用户接车信息删除异常：【{}】", e.getMessage(), e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("用户接车信息删除成功");
    }
    /**
     * @Description:查询接车地址详情
     * @param vehicleInvoiceInfoDTO
     * @return InvokeResult<VehicleAcceptAddressDto>
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 16:18
    */
    @SuppressWarnings("unchecked")
    @PostMapping("/queryAcceptAddress")
    public InvokeResult<VehicleAcceptAddressDto> queryDetail(@RequestBody VehicleAcceptAddressDto vehicleInvoiceInfoDTO){
        LOGGER.info("用户接车信息修改查询，查询条件：{}",JacksonUtil.fromObjectToJson(vehicleInvoiceInfoDTO));
        VehicleAcceptAddressDto vehicleAcceptAddressDto = new VehicleAcceptAddressDto();
        try {
            vehicleAcceptAddressDto = vehicleAcceptAddressService.queryDetail(vehicleInvoiceInfoDTO);
        } catch (BzException e) {
           LOGGER.error("用户接车信息修改查询异常：【{}】",e.getMessage(), e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(vehicleAcceptAddressDto);
    }
    /**
     * @Description:查询接车地址信息列表
     * @param vehicleInvoiceInfoDTO
     * @return InvokeResult<List<VehicleAcceptAddressDto>>
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 16:19
    */
    @SuppressWarnings("unchecked")
    @PostMapping("/queryListAcceptAddress")
    public InvokeResult<List<VehicleAcceptAddressDto>> listQueryDetail(@RequestBody VehicleAcceptAddressDto vehicleInvoiceInfoDTO){
        LOGGER.info("用户查询接车信息列表，查询条件：{}",JacksonUtil.fromObjectToJson(vehicleInvoiceInfoDTO));
        List<VehicleAcceptAddressDto> result = new ArrayList<>();
        try {
            result = vehicleAcceptAddressService.pageQueryDetail(vehicleInvoiceInfoDTO);
        } catch (BzException e) {
            LOGGER.error("用户查询接车信息列表异常：【{}】",e.getMessage(), e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(result);
    }
}
