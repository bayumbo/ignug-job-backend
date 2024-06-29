package com.bolsaempleo.backend.app.services;

import java.util.List;
import com.bolsaempleo.backend.app.dto.UsersDto;
import com.bolsaempleo.backend.app.dto.UsersResponseDto;
import com.bolsaempleo.backend.app.entities.authentication.Users;


public interface UsersService {

    List<Users> findAll();
    UsersResponseDto findAllDto();
    UsersResponseDto findByIdDto(Long Id);
    UsersResponseDto saveUserDto(UsersDto usersDto);
    UsersResponseDto deteleUserDto(Long Id);
}
