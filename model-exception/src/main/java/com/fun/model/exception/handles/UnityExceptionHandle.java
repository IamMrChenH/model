package com.fun.model.exception.handles;

import com.fun.model.exception.base.BaseException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 *
 * @author IamMr
 * @date 2019年10月20日 —— 20:28
 */
@RestControllerAdvice
public class UnityExceptionHandle {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity exceptionHandle(HttpServletRequest req, BaseException e) {
        return generateResponseEntity(e);
    }

    @ExceptionHandler({Throwable.class})
    public ResponseEntity exceptionHandle(Throwable e) {
        BaseException internalServerError = new BaseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return generateResponseEntity(internalServerError);
    }

    /**
     * 生成返回类
     *
     * @param e
     * @return
     */
    public ResponseEntity generateResponseEntity(BaseException e) {
        ExceptionResult result = new ExceptionResult();
        result.setCode(e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(result);
    }

    /**
     * 返回的结果数据
     */
    @Data
    class ExceptionResult {

        /**
         * 时间
         */
        private Long time = System.currentTimeMillis();

        /**
         * 错误提示
         */
        private String code;
    }


}
