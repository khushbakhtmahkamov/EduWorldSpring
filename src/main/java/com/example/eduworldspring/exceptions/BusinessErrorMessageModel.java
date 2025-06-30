package com.example.eduworldspring.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessErrorMessageModel {
    private String message;
    private BusinessExceptionCode businessExceptionCode;
}
