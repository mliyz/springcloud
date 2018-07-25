package com.liyz.fallInLove.dto.goods;

import com.yixin.common.utils.BaseDTO;

/**
 *
 * @ClassName: GoodsSalePlaceDTO
 * @Description 商品可销售地区维护DTO
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 上午11:45:03
 *
 */
public class GoodsSalePlaceDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883247742383365437L;

    /**
     * 商品ID
     */
    private String goodsinfoId;

    /**
     * 地址类型 0-全国，1-大区，2-省，3-市
     */
    private String placeType;

    /**
     * 地区编码
     */
    private String placeCode;

    /**
     * 地区名称
     */
    private String placeName;

    public String getGoodsinfoId() {
        return goodsinfoId;
    }

    public void setGoodsinfoId(String goodsinfoId) {
        this.goodsinfoId = goodsinfoId;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
