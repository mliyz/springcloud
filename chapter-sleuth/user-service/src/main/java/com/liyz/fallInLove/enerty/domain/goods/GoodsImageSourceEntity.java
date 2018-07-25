package com.liyz.fallInLove.enerty.domain.goods;


import com.liyz.fallInLove.enerty.domain.BZBaseEntiy;
import com.liyz.fallInLove.enerty.domain.attach.AttachSourceEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @ClassName: GoodsImageSourceEntity
 * @Description 商品图片资源表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月28日 上午10:45:03
 *
 */
@Entity
@Table(name = "ba_goods_image_source")
public class GoodsImageSourceEntity extends BZBaseEntiy
{

    private static final long serialVersionUID = 8883246642383365437L;

    /**
     * 商品ID
     */
    @Column(name = "goodsinfo_id",length = 50)
    private String goodsinfoId;

    /**
     * 图片类型 1-车源图片，2-交易页图片
     */
    @Column(name = "image_type",length = 10)
    private String imageType;

    /**
     * 颜色
     */
    @Column(name = "color_name",length = 16)
    private String colorName;

    /**
     * 图片索引位置
     */
    @Column(name = "image_index")
    private Integer imageIndex;
    @Transient
    private AttachSourceEntity attachSourceEntity;

    public AttachSourceEntity getAttachSourceEntity() {
        return attachSourceEntity;
    }

    public void setAttachSourceEntity(AttachSourceEntity attachSourceEntity) {
        this.attachSourceEntity = attachSourceEntity;
    }

    public String getGoodsinfoId() {
        return goodsinfoId;
    }

    public void setGoodsinfoId(String goodsinfoId) {
        this.goodsinfoId = goodsinfoId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(Integer imageIndex) {
        this.imageIndex = imageIndex;
    }
}
