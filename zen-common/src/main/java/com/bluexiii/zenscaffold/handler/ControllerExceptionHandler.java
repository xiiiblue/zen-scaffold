package com.bluexiii.zenscaffold.handler;

import com.bluexiii.zenscaffold.exception.BusinessException;
import com.bluexiii.zenscaffold.exception.ResourceNotFoundException;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.bluexiii.zenscaffold.dto.ApiError;
import com.bluexiii.zenscaffold.exception.AlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Iterator;

/**
 * 异常处理
 * Created by bluexiii on 16/9/6.
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * ResourceNotFoundException 找不到资源 404 404
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ApiError handleRunTimeException(ResourceNotFoundException ex) {
        logger.error(ex.getMessage());
        return new ApiError(404, 404, ex.getMessage());
    }

    /**
     * AlreadyExistsException 资源已存在 409 409
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseBody
    public ApiError handleRunTimeException(AlreadyExistsException ex) {
        logger.error(ex.getMessage());
        return new ApiError(409, 409, ex.getMessage());
    }

    /**
     * DataIntegrityViolationException SQL执行异常 409 801
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ApiError handleRunTimeException(DataIntegrityViolationException ex) {
        logger.error(ex.getMessage());
        return new ApiError(409, 801, "SQL执行异常", ex.getMessage(), null);
    }

    /**
     * HttpMessageNotReadableException 请求参数无法识别 409 802
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ApiError handleRunTimeException(HttpMessageNotReadableException ex) {
        logger.error(ex.getMessage());
        return new ApiError(409, 802, "请求参数无法识别", ex.getMessage(), null);
    }


    /**
     * BusinessException 通用业务逻辑异常 409 ???
     * 无明确分类的业务逻辑异常，status=406 code=自定义
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ApiError handleRunTimeException(BusinessException ex) {
        logger.error(ex.getMessage());
        return new ApiError(409, ex.getCode(), ex.getMessage());
    }

    /**
     * MethodArgumentNotValidException JSR303参数校验异常 422 422
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiError handleRunTimeException(MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder("参数验证失败,数量:").append(ex.getBindingResult().getErrorCount());

        Iterator iterator = ex.getBindingResult().getAllErrors().iterator();
        while (iterator.hasNext()) {
            ObjectError error = (ObjectError) iterator.next();
            DefaultMessageSourceResolvable argument = (DefaultMessageSourceResolvable) error.getArguments()[0];
            String errorParameter = argument.getDefaultMessage();
            String errorMessage = error.getDefaultMessage();
            sb.append(" [名称:").append(errorParameter).append(" 描述:").append(errorMessage).append("] ");
        }
        return new ApiError(422, 422, sb.toString(), null, null);
    }

    /**
     * HystrixRuntimeException Hystrix异常 503 503
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(HystrixRuntimeException.class)
    @ResponseBody
    public ApiError handleRunTimeException(HystrixRuntimeException ex) {
        logger.error(ex.getMessage());
        return new ApiError(503, 503, ex.getMessage());
    }

    /**
     * Exception 其它异常 500 500
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiError handleRunTimeException(Exception ex) {
        ex.printStackTrace();
        logger.error(ex.getMessage());
        return new ApiError(500, 500, ex.getMessage());
    }
}