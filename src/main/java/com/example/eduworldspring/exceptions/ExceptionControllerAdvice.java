package com.example.eduworldspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BusinessRuntimeException.class)
    public ResponseEntity<BusinessErrorMessageModel> handleBusinessRuntimeException(BusinessRuntimeException exception) {

        HttpStatus httpStatus;
        switch (exception.getBusinessExceptionCode()) {
            case BAD_REQUEST:
            case PERSISTENCE_ERROR:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
            case NOT_FOUND:
                httpStatus = HttpStatus.NOT_FOUND;
                break;
            case INTERNAL_ERROR:
            case COULD_NOT_UPDATE:
            case COULD_NOT_DELETE:
            case COULD_NOT_SAVE:
                httpStatus = HttpStatus.CONFLICT;
                break;
            default:
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }

        BusinessErrorMessageModel errorMessage = new BusinessErrorMessageModel(
                exception.getMessage(),
                exception.getBusinessExceptionCode()

        );

        return new ResponseEntity<>(errorMessage, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BusinessErrorMessageModel> handleGeneralException(Exception exception) {
        BusinessErrorMessageModel errorMessage = new BusinessErrorMessageModel(
                "An unexpected error occurred: " + exception.getMessage(),
                BusinessExceptionCode.INTERNAL_ERROR
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
