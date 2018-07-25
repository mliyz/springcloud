package com.liyz.fallInLove.dto.goods;

import com.liyz.fallInLove.dto.attach.AttachSourceDTO;
import com.yixin.common.utils.BaseDTO;

/**
 *
 * @ClassName: GoodsImageSourceDTO
 * @Description 商品图片资源DTO
 * @author YixinCapital -- lianghaoguan
 * @date 2018年5月28日 上午10:45:03
 *
 */
public class GoodsImageSourceDTO extends BaseDTO
{

    private static final long serialVersionUID = 8883246642383365437L;

    /**
     * 商品ID
     */
    private String goodsinfoId;

    /**
     * 图片类型 1-车源图片，2-交易页图片
     */
    private String imageType;

    /**
     * 颜色
     */
    private String colorName;

    /**
     * 图片索引位置
     */
    private Integer imageIndex;

    /**
     * 附件资源DTO(1:1)
     */
    private AttachSourceDTO attachSourceDTO;

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

    public AttachSourceDTO getAttachSourceDTO() {
        return attachSourceDTO;
    }

    public void setAttachSourceDTO(AttachSourceDTO attachSourceDTO) {
        this.attachSourceDTO = attachSourceDTO;
    }

}
