package com.liyz.common.util;

import java.io.Serializable;

/**
 * 定时任务
 * Package : com.liyz.common.utils
 *
 */
public class JobParamDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /**
     * 执行结果
     */
    private int status;

    /**
     * 是否需要重试：true 需要；false 不需要
     */
    private boolean retryFlag=false;

    /**
     * 执行任务需要的参数
     */
    private String agrs;

    /**
     * 执行结果编码
     */
    private String resultCode;

    /**
     * 执行结果说明
     */
    private String resultContent;

    public boolean isRetryFlag() {
        return retryFlag;
    }

    public void setRetryFlag(boolean retryFlag) {
        this.retryFlag = retryFlag;
    }

    public String getAgrs() {
        return agrs;
    }

    public void setAgrs(String agrs) {
        this.agrs = agrs;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
