package com.liyz.fallInLove.enerty.domain.goods;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: GoodsSalePlaceEntity
 * @Description 商品可销售地区维护表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 上午11:45:03
 *
 */
@Entity
@Table(name = "ba_goods_sale_place")
public class GoodsSalePlaceEntity extends BZBaseEntiy{

    private static final long serialVersionUID = 8883247742383365437L;

    /**
     * 商品ID
     */
    @Column(name = "goodsinfo_id",length = 50)
    private String goodsinfoId;

    /**
     * 地址类型 0-全国，1-大区，2-省，3-市
     */
    @Column(name = "place_type",length = 10)
    private String placeType;

    /**
     * 地区编码
     */
    @Column(name = "place_code",length = 20)
    private String placeCode;

    /**
     * 地区名称
     */
    @Column(name = "place_name",length = 50)
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
