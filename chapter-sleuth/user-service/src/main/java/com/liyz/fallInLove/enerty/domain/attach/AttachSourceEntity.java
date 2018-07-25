package com.liyz.fallInLove.enerty.domain.attach;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: AttachSourceEntity
 * @Description 附件资源表
 * @author YixinCapital -- mjj
 * @date 2018年5月30日 上午9:03:41
 *
 */
@Entity
@Table(name = "ba_attach_source")
public class AttachSourceEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 7787523788948492599L;

    /**
     * 业务表id
     */
    @Column(name = "buss_id", length = 50)
    private String bussId;

    /**
     * 附件类型
     */
    @Column(name = "attch_type", length = 50)
    private String attchType;

    /**
     * 附件存储路径
     */
    @Column(name = "attch_path", length = 200)
    private String attchPath;

    /**
     * 资源附件原始名称
     */
    @Column(name = "source_attch_name", length = 100)
    private String sourceAttchName;

    /**
     * 压缩后图片路径
     */
    @Column(name = "compress_attch_path", length = 200)
    private String compressAttchPath;

    public String getBussId() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId = bussId;
    }

    public String getAttchType() {
        return attchType;
    }

    public void setAttchType(String attchType) {
        this.attchType = attchType;
    }

    public String getAttchPath() {
        return attchPath;
    }

    public void setAttchPath(String attchPath) {
        this.attchPath = attchPath;
    }

    public String getSourceAttchName() {
        return sourceAttchName;
    }

    public void setSourceAttchName(String sourceAttchName) {
        this.sourceAttchName = sourceAttchName;
    }

    public String getCompressAttchPath() {
        return compressAttchPath;
    }

    public void setCompressAttchPath(String compressAttchPath) {
        this.compressAttchPath = compressAttchPath;
    }

}
