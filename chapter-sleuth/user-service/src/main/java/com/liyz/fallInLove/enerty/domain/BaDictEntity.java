package com.liyz.fallInLove.enerty.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 字典表
 * @ClassName: BaDictEntity
 * @Description 字典类
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月29日 下午5:35:52
 *
 */
@Entity
@Table(name = "ba_dict")
public class BaDictEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 8211356037130152314L;

    /**
     * 类型code
     */
    @Column(name = "type_code",length = 20)
    private String typeCode;
    
    /**
     * 类型名称
     */
    @Column(name = "type_name",length = 100)
    private String typeName;

    /**
     * 业务code
     */
    @Column(name = "buss_code",length = 20)
    private String bussCode;

    /**
     * 业务名称
     */
    @Column(name = "buss_name",length = 100)
    private String bussName;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBussCode() {
        return bussCode;
    }

    public void setBussCode(String bussCode) {
        this.bussCode = bussCode;
    }

    public String getBussName() {
        return bussName;
    }

    public void setBussName(String bussName) {
        this.bussName = bussName;
    }
}
