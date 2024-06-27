package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class UsersResponseDto implements Serializable{

    @Getter
	@Setter
	private String code;
	@Getter
	@Setter
    private String message;
	@Getter
	@Setter
    private UsersDto  User;
	@Getter
	@Setter
    private List<UsersDto> listUsers;

}
