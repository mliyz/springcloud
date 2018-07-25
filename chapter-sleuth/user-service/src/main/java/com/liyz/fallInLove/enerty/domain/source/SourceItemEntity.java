package com.liyz.fallInLove.enerty.domain.source;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: UserRoleRelateEntity
 * @Description 资源表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_source_item")
public class SourceItemEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 9164526030421593456L;

    /**
     * 元素编号
     */
    @Column(name = "item_code",length = 125)
    private String itemCode;

    /**
     * 元素名称
     */
    @Column(name = "item_name",length = 125)
    private String itemName;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
