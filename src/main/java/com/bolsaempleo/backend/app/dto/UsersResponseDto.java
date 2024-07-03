package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponseDto implements Serializable{

	private String code;
    private String message;
    private Object data;

}
