package com.bluexiii.zenscaffold.exception;

/**
 * Created by bluexiii on 16/9/5.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
