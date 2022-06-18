package com.tenis.apirest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TenisNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TenisNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String TenisNotFoundHandler(TenisNotFoundException ex) {
        return ex.getMessage();
    }
}