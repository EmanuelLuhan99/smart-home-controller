package com.endava.emanuel_luhan.smart_home_controller.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiErrorResponse {

    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;
}
