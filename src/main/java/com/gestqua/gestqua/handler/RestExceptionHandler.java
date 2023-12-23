package com.gestqua.gestqua.handler;

import com.gestqua.gestqua.Exceptions.EntityNotFoundException;
import com.gestqua.gestqua.Exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException entityNotFoundException, WebRequest webRequest){
        final HttpStatus notfoud =HttpStatus.NOT_FOUND;
        final  ErrorDto build = ErrorDto.builder()
                .codes(entityNotFoundException.getErrorCodes())
                .httpcode(notfoud.value())
                .message(entityNotFoundException.getMessage())
                .build();

        return new ResponseEntity<>(build, notfoud);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest){
        final HttpStatus badRequest= HttpStatus.BAD_REQUEST;
        final  ErrorDto build = ErrorDto.builder()
                .codes(exception.getErrorCodes())
                .httpcode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(build, badRequest);
    }
}
