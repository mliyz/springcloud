package com.liyz.fallInLove.dto.common;

/**
 * Created by lianghaoguan on 2018/5/22.
 * 上传附件DTO
 */
public class AttachmentDTO {

    private byte[] fileSource;

    private String sourceFileName;

    public byte[] getFileSource() {
        return fileSource;
    }

    public void setFileSource(byte[] fileSource) {
        this.fileSource = fileSource;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }
}
