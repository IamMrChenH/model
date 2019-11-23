package com.fun.model.exception;


import com.fun.model.exception.base.BaseException;
import org.springframework.http.HttpStatus;

/**
 * 400 请求参数有误
 *
 * @author IamMr
 * @date 2019年10月20日 —— 20:31
 */
public class BadRequestException extends BaseException {
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
