package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginJWTResponseDto {
	private String code;
    private String message;
    private Object data;
}
