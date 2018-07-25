package com.liyz.fallInLove.service.impl.persion;

import com.liyz.common.system.querychannel.QueryChannelService;
import com.liyz.common.util.JacksonUtil;
import com.liyz.common.util.ValidatorUtil;
import com.liyz.common.util.exception.BzException;
import com.liyz.fallInLove.assembler.persion.VehicleAcceptAddressAssembler;
import com.liyz.fallInLove.dto.person.VehicleAcceptAddressDto;
import com.liyz.fallInLove.enerty.domain.person.VehicleAcceptAddressEntity;
import com.liyz.fallInLove.service.persion.VehicleAcceptAddressService;
import com.yixin.common.utils.InvokeResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @ClassName: VehicleAcceptAddressServiceImpl
 * @Description 用户接车信息
 * @author  YixinCapital -- liyuzhang
 * @date  2018年5月22日 上午9:34:23
 *
 */
@Service
public class VehicleAcceptAddressServiceImpl implements VehicleAcceptAddressService {

    private Logger logger = LoggerFactory.getLogger(VehicleAcceptAddressServiceImpl.class);

    @Autowired
    QueryChannelService queryChannel;
    /**
     * @Description: 用户接车信息添加
     * @Title:addVehicleAcceptAddress
     * @param vehicleAcceptAddressDto
     * @return
     * @throws BzException
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 9:53
    */
    @Transactional
    @Override
    public void addVehicleAcceptAddress(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException
    {
        try {
            logger.info("用户接车地址添加,接车信息：{}", JacksonUtil.fromObjectToJson(vehicleAcceptAddressDto));
            //查询用户的接车地址数量
            /*List<Object> conditionVals = new ArrayList<Object>();
            StringBuilder str=new StringBuilder();
            str.append("select count(a.id) from VehicleAcceptAddressEntity a where 1=1 and a.deleted = false ");
            str.append("and a.userinfoId=? ");
            str.append("and a.addrType=?");
            conditionVals.add(vehicleAcceptAddressDto.getUserinfoId());
            conditionVals.add(vehicleAcceptAddressDto.getAddrType());
	        Long singleResult = (Long) queryChannel.createJpqlQuery(str.toString()).setParameters(conditionVals).singleResult();
            //如果用户接车地址信息超过10条，则不可以添加
	        if(singleResult != null){
	        	if(singleResult >= 10){
			        throw new BzException("您的接车地址已达上限, 不可新增！");
		        }
	        }
            //判断添加的地址是否是默认地址，如果是默认地址，则修改之前的默认地址为false
            if(vehicleAcceptAddressDto.getsDefault()){
                updataOldAcceptAddress(vehicleAcceptAddressDto,false);
            }*/
            InvokeResult<String> invokeResult = new InvokeResult();
            invokeResult = ValidatorUtil.validate(vehicleAcceptAddressDto);
            if(invokeResult.isHasErrors()){
                //校验字段
                throw new BzException(invokeResult.getErrorMessage());
            }
            //类转换
            VehicleAcceptAddressEntity vehicleAcceptAddressEntity = VehicleAcceptAddressAssembler.toEntity(vehicleAcceptAddressDto);
            vehicleAcceptAddressEntity.create();
        } catch (Exception e) {
            logger.error("用户新增接车信息地址异常，异常信息【{}】", e.getMessage(), e);
            updataOldAcceptAddress(vehicleAcceptAddressDto,true);
            throw new BzException(e.getMessage());
        }
    }
    /**
     * @Description:删除用户接车地址
     * @Title: deleteVehicleAcceptAddress
     * @param  vehicleAcceptAddressDto
     * @return
     * @throws BzException
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 10:32
    */
    @Transactional
    @Override
    public void deleteVehicleAcceptAddress(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException
    {
        try {
            logger.info("用户接车地址删除,删除信息：{}", JacksonUtil.fromObjectToJson(vehicleAcceptAddressDto));
            if(StringUtils.isBlank(vehicleAcceptAddressDto.getId())){
                throw new BzException("请选择删除接车地址信息");
            }
            VehicleAcceptAddressEntity entity = VehicleAcceptAddressEntity.get(VehicleAcceptAddressEntity.class, vehicleAcceptAddressDto.getId());
            entity.logicRemove();
        } catch (Exception e) {
            logger.error("用户删除接车地址信息异常：{}",e.getMessage(), e);
            throw new BzException(e.getMessage());
        }
    }
    /**
     * @Description:用户修改接车地址信息
     * @Title: updateVehicleAcceptAddress
     * @param  vehicleAcceptAddressDto
     * @return
     * @throws BzException
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 10:48
    */
    @Transactional
    @Override
    public void updateVehicleAcceptAddress(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException
    {
        try {
            logger.info("用户接车地址修改，接车地址修改信息：{}",JacksonUtil.fromObjectToJson(vehicleAcceptAddressDto));
            if (StringUtils.isBlank(vehicleAcceptAddressDto.getId())){
                throw new BzException("请选择接车信息");
            }
            //此地址修改为默认地址时，修改其他地址为非默认地址
            if(vehicleAcceptAddressDto.getsDefault()){
                updataOldAcceptAddress(vehicleAcceptAddressDto,false);
            }

            Map<String, Object> propValues = new HashMap<String, Object>();
            propValues.put("id", vehicleAcceptAddressDto.getId());
            propValues.put("deleted", false);
            VehicleAcceptAddressEntity entity = VehicleAcceptAddressEntity.findFirstByProperties(VehicleAcceptAddressEntity.class,propValues);
            //用户接车信息均为必填信息，若有没有填写的返回提示
            //接车信息ID
            entity.setId(vehicleAcceptAddressDto.getId());
            
	        InvokeResult<String> invokeResult = new InvokeResult();
	        invokeResult = ValidatorUtil.validate(vehicleAcceptAddressDto);
	        if(invokeResult.isHasErrors()){
		        //校验字段
		        throw new BzException(invokeResult.getErrorMessage());
	        }
	        //所在地区
            entity.setRegionCode(vehicleAcceptAddressDto.getRegionCode());
            entity.setRegionName(vehicleAcceptAddressDto.getRegionName());
            //详细地址
            entity.setAddress(vehicleAcceptAddressDto.getAddress());
            //邮政编码
            entity.setPostCode(vehicleAcceptAddressDto.getPostCode());
            //接车人姓名
            entity.setAccepterName(vehicleAcceptAddressDto.getAccepterName());
            entity.setUserinfoId(vehicleAcceptAddressDto.getUserinfoId());
            //手机号码
            entity.setAccepterPhone(vehicleAcceptAddressDto.getAccepterPhone());
            //默认接车地址
            entity.setsDefault(vehicleAcceptAddressDto.getsDefault());
            entity.update();
        } catch (Exception e) {
            logger.error("用户修改接车信息地址异常：{}",e.getMessage(), e);
            updataOldAcceptAddress(vehicleAcceptAddressDto,true);
            throw new BzException(e.getMessage());
        }
    }
    
    /**
     * @Description:用户接车信息列表查询
     * @Title: pageQueryDetail
     * @param  vehicleAcceptAddressDto
     * @return VehicleAcceptAddressDto>
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 11:20
    */
    @Transactional
    @Override
    public List<VehicleAcceptAddressDto> pageQueryDetail(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException
    {
        List<VehicleAcceptAddressDto> result= null;
        try {
            logger.info("用户接车信息查询，查询条件：{}",JacksonUtil.fromObjectToJson(vehicleAcceptAddressDto));
            result = new ArrayList<>();
            List<Object> conditionVals = new ArrayList<Object>();
            StringBuilder str=new StringBuilder();
            str.append("select a from VehicleAcceptAddressEntity a where 1=1 and a.deleted = false ");
            str.append("and a.userinfoId=? ");
            str.append("and a.addrType=?");
            //根据是否默认地址降序排序
            str.append("ORDER BY is_default DESC ");
            conditionVals.add(vehicleAcceptAddressDto.getUserinfoId());
            conditionVals.add(vehicleAcceptAddressDto.getAddrType());
            List<VehicleAcceptAddressEntity> list = queryChannel.createJpqlQuery(str.toString()).setParameters(conditionVals).list();
            result= VehicleAcceptAddressAssembler.toDTOs(list);
        } catch (Exception e) {
           logger.error("获取接车信息列表异常：{}",e.getMessage(), e);
           throw new BzException(e.getMessage());
        }
        return result;
    }
    /**
     * @Description:获取一条接车信息，查询用于修改页的信息
     * @Title:queryDetail
     * @param vehicleAcceptAddressDto
     * @return  VehicleAcceptAddressDto>
     * @author YixinCapital -- liyuzhang
     *         2018/5/22 14:29
    */
    public VehicleAcceptAddressDto queryDetail(VehicleAcceptAddressDto vehicleAcceptAddressDto) throws BzException
    {
        try {
            logger.info("查询一条接车信息，查询条件：{}",JacksonUtil.fromObjectToJson(vehicleAcceptAddressDto));
            VehicleAcceptAddressEntity entity = VehicleAcceptAddressEntity.get(VehicleAcceptAddressEntity.class, vehicleAcceptAddressDto.getId());
            vehicleAcceptAddressDto = VehicleAcceptAddressAssembler.toDto(entity);
        } catch (Exception e) {
            logger.error("查询用户接车信息异常:{}",e.getMessage(), e);
            throw new BzException(e.getMessage());
        }
        return vehicleAcceptAddressDto;
    }
    /**
     * @Description:用户修改原默认接车地址
     * @Title:  updataOldAcceptAddress
     * @param   vehicleAcceptAddressDto
     * @return
     * @author YixinCapital -- liyuzhang
     *         2018/5/23 10:58
    */
    @Transactional
    public void updataOldAcceptAddress(VehicleAcceptAddressDto vehicleAcceptAddressDto,Boolean flag){
        Map<String, Object> propValues1 = new HashMap<String, Object>();
        propValues1.put("userinfoId",vehicleAcceptAddressDto.getUserinfoId());
        propValues1.put("deleted", false);
        propValues1.put("addrType",vehicleAcceptAddressDto.getAddrType());
        propValues1.put("sDefault",true);
        VehicleAcceptAddressEntity entity1 = VehicleAcceptAddressEntity.findFirstByProperties(VehicleAcceptAddressEntity.class, propValues1);
        if(entity1 != null){
            entity1.setsDefault(flag);
            entity1.update();
        }
    }
}
