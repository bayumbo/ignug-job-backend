package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorDto {

    private String code;
    private String message;
    private Object data;
}
