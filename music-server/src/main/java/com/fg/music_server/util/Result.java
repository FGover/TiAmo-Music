package com.fg.music_server.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> {
    private Integer code;   // 状态码
    private String message; // 返回的信息
    private T data;    // 返回的数据

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功的响应
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static Result<Void> success() {
        return new Result<>(200, "success", null);
    }

    // 自定义状态码和信息的失败响应
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message ,null);
    }
}
