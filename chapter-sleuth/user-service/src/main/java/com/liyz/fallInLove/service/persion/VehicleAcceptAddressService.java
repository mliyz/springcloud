package com.liyz.fallInLove.service.persion;

import com.liyz.fallInLove.dto.person.VehicleAcceptAddressDto;
import com.yixin.common.exception.BzException;

import java.util.List;


/**
 * @ClassName: VehicleAcceptAddress
 * @Description 接车信息维护地址
 * @author  YixinCapital -- liyuzhang
 * @date  2018年5月22日 下午9:20:06
 *
 */
public interface VehicleAcceptAddressService {
    /**
     *
     * @Description: 用户新增接车信息地址
     * 先判断当前用户的有效接车地址信息数量，用户接车地址信息最大为10条地址，如果超出最大地址数量，则不可以添加
     * @param vehicleAcceptAddressDto
     * @return
     * @throws BzException String
     * @throws
     * @author YixinCapital -- liyuzhang
     *	       2018年5月21日 下午5:33:28
     */
    void addVehicleAcceptAddress(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException;

    /**
     *
     * @Description: 用户修改接车信息地址
     * @param vehicleAcceptAddressDto
     * @return
     * @throws BzException String
     * @throws
     * @author YixinCapital -- liyuzhang
     *	       2018年5月21日 下午5:33:31
     */
    void deleteVehicleAcceptAddress(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException;

    /**
     *
     * @Description: 用户接车地址修改
     * @param vehicleAcceptAddressDto
     * @return
     * @throws BzException String
     * @throws
     * @author YixinCapital -- liyuzhang
     *	       2018年5月21日 下午5:33:35
     */
    void updateVehicleAcceptAddress(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException;

    /**
     *
     * @Description: 获取接车信息列表
     * @param vehicleAcceptAddressDto
     * @return
     * @throws BzException List<VehicleAcceptAddressDto>
     * @throws
     * @author YixinCapital -- liyuzhang
     *	       2018年5月21日 下午5:33:41
     */
    List<VehicleAcceptAddressDto> pageQueryDetail(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException;

    /**
     *
     * @Description: 获取接车信息
     * @param vehicleAcceptAddressDto
     * @return
     * @throws BzException VehicleAcceptAddressDto
     * @throws
     * @author YixinCapital -- liyuzhang
     *	       2018年5月22日 下午2:33:41
     */
    VehicleAcceptAddressDto queryDetail(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException;
}
