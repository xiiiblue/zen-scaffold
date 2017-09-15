package com.bluexiii.zenscaffold.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by bluexiii on 16/9/8.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private Integer status;
    private Integer code;
    private String message;
    private String developerMessage;
    private String moreInfo;

    public ApiError(Integer status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ApiError(Integer status, Integer code, String message, String developerMessage, String moreInfo) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
        this.moreInfo = moreInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}


