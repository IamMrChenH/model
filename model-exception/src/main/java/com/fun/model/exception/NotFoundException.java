package com.fun.model.exception;


import com.fun.model.exception.base.BaseException;
import org.springframework.http.HttpStatus;

/**
 * 404 找不到异常
 *
 * @author IamMr
 * @date 2019年10月20日 —— 20:31
 */
public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}
