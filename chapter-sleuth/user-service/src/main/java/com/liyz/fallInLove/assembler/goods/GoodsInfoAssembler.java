package com.liyz.fallInLove.assembler.goods;

import com.liyz.fallInLove.dto.attach.AttachSourceDTO;
import com.liyz.fallInLove.dto.goods.*;
import com.liyz.fallInLove.enerty.domain.goods.GoodsInfoEntity;
import com.liyz.fallInLove.enums.ColorEnum;
import com.liyz.fallInLove.enums.FormallitiesEnum;
import com.liyz.fallInLove.enums.PaymentTypeEnum;
import com.liyz.fallInLove.enums.VehicleTypeEnum;
import com.liyz.fallInLove.enums.goods.*;
import com.yixin.common.system.util.BaseAssembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @ClassName: GoodsInfoDetailAssembler
 * @Description GoodsInfoDetail转换类
 * @author YixinCapital -- mjj
 * @date 2018年5月28日 下午5:12:28
 *
 */
public class GoodsInfoAssembler extends BaseAssembler
{

    public static GoodsInfoDTO toDto(GoodsInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        GoodsInfoDTO dto = new GoodsInfoDTO();
        mapObj(entity, dto);
        return dto;
    }

    public static List<GoodsInfoDTO> toDTOs(List<GoodsInfoEntity> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        List<GoodsInfoDTO> dtoList = new ArrayList<GoodsInfoDTO>(entityList.size());
        int i = 1;
        for (GoodsInfoEntity entity : entityList) {
            GoodsInfoDTO dto = toDto(entity);
            dto.setSequence(i);
            i++;
            dtoList.add(dto);
        }
        return dtoList;
    }

    public static GoodsInfoEntity toEntity(GoodsInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        GoodsInfoEntity entity = new GoodsInfoEntity();
        mapObjWithoutNull(dto, entity);
        return entity;
    }

    /**
     * @param
     * @return List<CarDemo>
     * @author code generator
     */
    public static List<GoodsInfoEntity> toEntitys(List<GoodsInfoDTO> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        List<GoodsInfoEntity> entityList = new ArrayList<GoodsInfoEntity>(dtoList.size());
        for (GoodsInfoDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    /**
     *
     * @Description: 将数据库查询结果转换成DTO
     * @param objArrys
     * @param imgUrl 文件的存储绝对路径
     * @return GoodsInfoDTO
     * @throws @author YixinCapital -- mjj 2018年5月30日 上午11:00:03
     */
    public static GoodsInfoDTO toDTOsForResult(List<Object[]> objArrys, String imgUrl) {

        if (objArrys == null || objArrys.isEmpty()) {
            return null;
        }

        List<GoodsImageSourceDTO> goodsImageSourceList = new ArrayList<GoodsImageSourceDTO>();
        GoodsInfoDTO dto = new GoodsInfoDTO();
        GoodsImageSourceDTO goodsImageSourceDTO = new GoodsImageSourceDTO();
        AttachSourceDTO attachSourceDTO = new AttachSourceDTO();
        GoodsDeliveryModeDTO goodsDeliveryModeDTO = new GoodsDeliveryModeDTO();
        GoodsSalePlaceDTO goodsSalePlaceDTO = new GoodsSalePlaceDTO();
        if (objArrys.get(0)[0] != null) {
            dto.setId(String.valueOf(objArrys.get(0)[0]));
        }
        if (objArrys.get(0)[1] != null) {
            dto.setCarMasterBrandId(String.valueOf(objArrys.get(0)[1]));
        }
        if (objArrys.get(0)[2] != null) {
            dto.setCarMasterBrandName(String.valueOf(objArrys.get(0)[2]));
        }
        if (objArrys.get(0)[3] != null) {
            dto.setCarBrandId(String.valueOf(objArrys.get(0)[3]));
        }
        if (objArrys.get(0)[4] != null) {
            dto.setCarBrandName(String.valueOf(objArrys.get(0)[4]));
        }
        if (objArrys.get(0)[5] != null) {
            dto.setCarModelId(String.valueOf(objArrys.get(0)[5]));
        }
        if (objArrys.get(0)[6] != null) {
            dto.setCarModelName(String.valueOf(objArrys.get(0)[6]));
        }
        if (objArrys.get(0)[7] != null) {
            dto.setCarStyleId(String.valueOf(objArrys.get(0)[7]));
        }
        if (objArrys.get(0)[8] != null) {
            dto.setCarStyleName(String.valueOf(objArrys.get(0)[8]));
        }
        if (objArrys.get(0)[9] != null) {
            //车辆类型
            dto.setVehicleType(VehicleTypeEnum.getName((String)objArrys.get(0)[9]));
        }
        if (objArrys.get(0)[10] != null) {
            dto.setGarageCityCode(String.valueOf(objArrys.get(0)[10]));
        }
        if (objArrys.get(0)[11] != null) {
            dto.setGarageCityName(String.valueOf(objArrys.get(0)[11]));
        }
        if (objArrys.get(0)[12] != null) {
            //手续
            dto.setFormalities(FormallitiesEnum.getName((String)objArrys.get(0)[12]));
        }
        if (objArrys.get(0)[13] != null) {
            dto.setGuidePrice(String.valueOf( objArrys.get(0)[13]));
        }
        if (objArrys.get(0)[14] != null) {
            dto.setDiscountPrice(String.valueOf( objArrys.get(0)[14]));
        }
        if (objArrys.get(0)[15] != null) {
            dto.setSellPrice(String.valueOf( objArrys.get(0)[15]));
        }
        if (objArrys.get(0)[16] != null) {
            //交易方式
            dto.setPaymentType(PaymentTypeEnum.getName((String)objArrys.get(0)[16]));
        }
        if (objArrys.get(0)[17] != null) {
            dto.setPaymentCommission(String.valueOf( objArrys.get(0)[17]));
        }
//        if (objArrys.get(0)[18] != null) {
//            dto.setDepositPaymentCommission(String.valueOf( objArrys.get(0)[18]));
//        }
        if (objArrys.get(0)[19] != null) {
            dto.setDepositRatio(String.valueOf( objArrys.get(0)[19]));
        }
        if (objArrys.get(0)[20] != null) {
            //发票类型
            dto.setInvoiceType(String.valueOf(objArrys.get(0)[20]));
        }
        if (objArrys.get(0)[21] != null) {
            dto.setMinQuantity((Integer) objArrys.get(0)[21]);
        }
        if (objArrys.get(0)[22] != null) {
            dto.setDepartureTime((Date) objArrys.get(0)[22]);
        }
        if (objArrys.get(0)[23] != null) {
            dto.setFareBearer(String.valueOf(objArrys.get(0)[23]));
        }
        if (objArrys.get(0)[24] != null) {
            dto.setReleaseTime((Date) objArrys.get(0)[24]);
        }
        if (objArrys.get(0)[25] != null) {
            dto.setBusinessType(String.valueOf(objArrys.get(0)[25]));
        }
        if (objArrys.get(0)[26] != null) {
            dto.setContactName(String.valueOf(objArrys.get(0)[26]));
        }
        if (objArrys.get(0)[27] != null) {
            dto.setContactStyle(String.valueOf(objArrys.get(0)[27]));
        }
        if (objArrys.get(0)[28] != null) {
            dto.setRemark(String.valueOf(objArrys.get(0)[28]));
        }
        if (objArrys.get(0)[29] != null) {
            dto.setGoodsStatus(String.valueOf(objArrys.get(0)[29]));
        }
        if (objArrys.get(0)[30] != null) {
            dto.setUpShelfDate((Date) objArrys.get(0)[30]);
        }
        if (objArrys.get(0)[31] != null) {
            dto.setDownShelfDate((Date) objArrys.get(0)[31]);
        }
        if (objArrys.get(0)[32] != null) {
            dto.setGoodsIndex((Integer) objArrys.get(0)[32]);
        }
        if (objArrys.get(0)[33] != null) {
            goodsDeliveryModeDTO.setDeliveryModeType(String.valueOf(objArrys.get(0)[33]));
        }
        if (objArrys.get(0)[34] != null) {
            goodsDeliveryModeDTO.setDeliveryModeDesc(String.valueOf(objArrys.get(0)[34]));
        }
        if (objArrys.get(0)[35] != null) {
            goodsSalePlaceDTO.setPlaceType(String.valueOf(objArrys.get(0)[35]));
        }
        if (objArrys.get(0)[36] != null) {
            goodsSalePlaceDTO.setPlaceCode(String.valueOf(objArrys.get(0)[36]));
        }
        if (objArrys.get(0)[37] != null) {
            goodsSalePlaceDTO.setPlaceName(String.valueOf(objArrys.get(0)[37]));
        }

        for (Object[] object : objArrys) {
            if (object[38] != null) {
                goodsImageSourceDTO.setImageType(String.valueOf(object[38]));
            }
            if (object[39] != null) {
                attachSourceDTO.setAttchPath(imgUrl + String.valueOf(object[39]));
            }
            if (object[40] != null) {
                //颜色
                goodsImageSourceDTO.setColorName(ColorEnum.getColorDesc((String)object[40]));
            }
            if (object[41] != null) {
                attachSourceDTO.setSourceAttchName(String.valueOf(object[41]));
            }
            if (object[42] != null) {
                attachSourceDTO.setCompressAttchPath(imgUrl + String.valueOf(object[42]));
            }
            goodsImageSourceDTO.setAttachSourceDTO(attachSourceDTO);
            goodsImageSourceList.add(goodsImageSourceDTO);
        }
        dto.setGoodsDelivery(goodsDeliveryModeDTO);
        dto.setGoodsSale(goodsSalePlaceDTO);
        dto.setGoodsImages(goodsImageSourceList);
        return dto;
    }

    /**
     * 将DTO有值得属性赋值给实体类
     * @param dto
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月22日 下午3:39:57
     */
    public static void assignmentEntity(GoodsInfoDTO dto,GoodsInfoEntity entity) {
        if (dto == null) {
            return;
        }
        mapObjWithoutNull(dto, entity);
    }

    public static List<GoodsInfoExportDTO> toExportDTOs(List<GoodsInfoDTO> goodsInfoDTOList) {
        if (goodsInfoDTOList == null) {
            return Collections.emptyList();
        }
        List<GoodsInfoExportDTO> dtoList = new ArrayList<>(goodsInfoDTOList.size());
        for (GoodsInfoDTO goodsInfoDTO : goodsInfoDTOList) {
            dtoList.add(toExportDTO(goodsInfoDTO));
        }
        return dtoList;
    }

    public static GoodsInfoExportDTO toExportDTO(GoodsInfoDTO goodsInfoDTO) {
        if (goodsInfoDTO == null) {
            return null;
        }
        GoodsInfoExportDTO dto = new GoodsInfoExportDTO();
        mapObj(goodsInfoDTO, dto);
        //车辆类型
        dto.setVehicleTypeStr(GoodsVehicleTypeEnum.getNameByCode(dto.getVehicleType()));
        //商品状态
        dto.setGoodsStatusStr(GoodsStatusEnum.getNameByCode(dto.getGoodsStatus()));
        //交易方式
        dto.setPaymentTypeStr(GoodsPaymentTypeEnum.getNameByCode(dto.getPaymentType()));
        //发票类型
        dto.setInvoiceTypeStr(GoodsInvoiceTypeEnum.getNameByCode(dto.getInvoiceType()));
        //手续
        dto.setFormalitiesStr(GoodsFormalitiesEnum.getNameByCode(dto.getFormalities()));
        //运费承担方
        dto.setFareBearerStr(GoodsFareBearerEnum.getNameByCode(dto.getFareBearer()));
        return dto;
    }
}
