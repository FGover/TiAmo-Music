package com.fg.music_server.exception;

import com.fg.music_server.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 处理自定义异常
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Result<Void>> handleCustomException(CustomException e) {
        // 直接根据业务状态码设置 HTTP 状态码
        log.error("业务异常：{}", e.getCode());
        HttpStatus httpStatus = HttpStatus.valueOf(e.getCode());
        Result<Void> result = Result.error(e.getCode(), e.getMessage());
        return new ResponseEntity<>(result, httpStatus);
    }

    // 处理其他异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<Void>> handleException(Exception e) {
        // 记录日志
        log.error("服务器内部错误：{}", e.getMessage());
        Result<Void> result = Result.error(500, "服务器内部错误");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
