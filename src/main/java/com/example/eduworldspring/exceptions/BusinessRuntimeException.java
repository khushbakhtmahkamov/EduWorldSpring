package com.example.eduworldspring.exceptions;

import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException {

    private final BusinessExceptionCode businessExceptionCode;

    public BusinessRuntimeException(BusinessExceptionCode businessExceptionCode, String message) {
        super(message);
        this.businessExceptionCode = businessExceptionCode;
    }
}
