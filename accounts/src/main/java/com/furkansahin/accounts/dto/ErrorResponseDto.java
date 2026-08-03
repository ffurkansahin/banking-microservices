package com.furkansahin.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class ErrorResponseDto {

    private String apiPath;

    private HttpStatus httpStatus;

    private String errorMessage;

    private LocalDateTime errorTime;
}
