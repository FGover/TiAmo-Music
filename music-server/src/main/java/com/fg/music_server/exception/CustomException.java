package com.fg.music_server.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final Integer code;

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
