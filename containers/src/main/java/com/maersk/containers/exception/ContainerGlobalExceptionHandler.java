package com.maersk.containers.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;


import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ContainerGlobalExceptionHandler {

	Logger log = LoggerFactory.getLogger(ContainerGlobalExceptionHandler.class);
	
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverExceptionHandler(Exception ex) {
        log.error(ex.getMessage(), ex);
        return "HTTP 500 INTERNAL SERVER ERROR";
    }
}
