package com.skmonjurul.product_service.exception.handler;


import com.fasterxml.jackson.core.JsonParseException;
import com.skmonjurul.product_service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage()).build();
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        if (ex.getCause() instanceof JsonParseException){
            return handleJsonParserError(ex);
        }
        return ErrorResponse.builder(ex, HttpStatus.BAD_REQUEST, ex.getMessage()).build();
    }
    
    public ErrorResponse handleJsonParserError(Throwable ex) {
        return ErrorResponse.builder(ex, HttpStatus.BAD_REQUEST, "Request json body is not valid").build();
    }
    
    
    @ExceptionHandler
    public ErrorResponse handleException(Exception ex) {
        return ErrorResponse.builder(ex, HttpStatus.INTERNAL_SERVER_ERROR,
                "Unknown error while processing the request").build();
    }
}
