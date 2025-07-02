package com.prf.demo.advice;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class ApiError {

	private LocalDateTime timestamp;
    private String error;
    private HttpStatus status;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String error, HttpStatus status) {
        this();
        this.error = error;
        this.status = status;
    }
}
