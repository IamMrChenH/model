package com.fun.model.exception.base;

import lombok.Getter;

/**
 * @author IamMr
 * @date 2019年10月21日 —— 22:09
 */
@Getter
public class BaseException extends RuntimeException {

    /**
     * 状态码 200 400 404......
     */
    private Integer status;

    public BaseException(Integer status, String message) {
        super(message);
        this.status = status;
    }
}
