package com.liyz.fallInLove.dto.attach;

import com.yixin.common.utils.BaseDTO;

/**
 *
 * @ClassName: AttachSourceDTO
 * @Description 附件资源DTO
 * @author YixinCapital -- mjj
 * @date 2018年5月30日 上午9:19:26
 *
 */
public class AttachSourceDTO extends BaseDTO
{

    private static final long serialVersionUID = -6737658624679390195L;

    /**
     * 业务表id
     */
    private String bussId;

    /**
     * 附件类型
     */
    private String attchType;

    /**
     * 附件存储路径
     */
    private String attchPath;

    /**
     * 资源附件原始名称
     */
    private String sourceAttchName;

    /**
     * 压缩后图片路径
     */
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
