package com.labseq.api.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1771117640811787306L;

    private final String code;
    private final HttpStatus status;
    private final String value;
}