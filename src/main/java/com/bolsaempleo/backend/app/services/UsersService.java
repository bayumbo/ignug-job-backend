package com.bolsaempleo.backend.app.services;

import java.util.List;
import java.util.UUID;

import com.bolsaempleo.backend.app.dto.ProfessionalUserDto;
import com.bolsaempleo.backend.app.dto.ProfessionalUserResponseDto;
import com.bolsaempleo.backend.app.dto.UsersDto;
import com.bolsaempleo.backend.app.dto.UsersResponseDto;
import com.bolsaempleo.backend.app.entities.authentication.Users;


public interface UsersService {

    List<Users> findAll();
    UsersResponseDto findAllDto();
    UsersResponseDto findByIdDto(UUID Id);
    UsersResponseDto saveUserDto(UsersDto usersDto);
    UsersResponseDto deteleUserDto(UUID Id);
    UsersResponseDto findByUserName(String userName);
    UsersResponseDto findByMail(String mail);
}
