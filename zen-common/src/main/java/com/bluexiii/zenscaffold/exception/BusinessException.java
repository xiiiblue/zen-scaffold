package com.bluexiii.zenscaffold.exception;

/**
 * 通用业务逻辑异常
 * Created by bluexiii on 16/8/24.
 */
public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
