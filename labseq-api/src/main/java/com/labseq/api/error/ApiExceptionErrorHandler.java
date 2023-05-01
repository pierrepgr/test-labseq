package com.labseq.api.error;

import com.labseq.api.error.ErrorResponse.ApiError;
import com.labseq.api.service.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiExceptionErrorHandler {

    private static final String NO_MESSAGE_AVAILABLE = "No message available";

    private final MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exception, Locale locale) {
        final String errorCode = exception.getCode();
        final HttpStatus status = exception.getStatus();
        final ErrorResponse errorResponse = ErrorResponse.of(status, toApiError(errorCode, locale));

        return ResponseEntity.badRequest().body(errorResponse);
    }

    private ApiError toApiError(String code, Locale locale, Object... args) {
        try {
            return new ApiError(code, this.messageSource.getMessage(code, args, locale));
        } catch (NoSuchMessageException ex) {
            log.error("Could not find any message for {} code under {}", code, locale);
            return new ApiError(code, NO_MESSAGE_AVAILABLE);
        }
    }
}
