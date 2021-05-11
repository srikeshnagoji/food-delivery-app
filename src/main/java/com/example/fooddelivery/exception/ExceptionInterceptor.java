package com.example.fooddelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Central exception handler for REST APIs.
 */
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    /**
     * Exception handler for custom business validation exception thrown.
     *
     * @param ex - ValidationException obejct
     * @param request - web request
     * @return - response entity having the relevant error details.
     */
    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Object> handleAllExceptions(ValidationException ex, WebRequest request){
        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getMessage(), ex.getDetails(), ex.getHint(), ex.getNextActions(), ex.getSupport());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception handler for custom exception thrown when any resource does not exist.
     *
     * @param ex - NotFoundException obejct
     * @param request - web request
     * @return - response entity having the relevant error details.
     */
    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public final ResponseEntity<Object> handleAllExceptions(NotFoundException ex, WebRequest request){
        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getMessage(), ex.getDetails(), ex.getHint(), ex.getNextActions(), ex.getSupport());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}