package org.study.exceptions;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiError {
    private String message;
    private String reason;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
