
package com.bolsaempleo.backend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bolsaempleo.backend.app.dto.UsersDto;
import com.bolsaempleo.backend.app.dto.UsersResponseDto;
import com.bolsaempleo.backend.app.services.UsersService;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    public UsersService usersService;

    @GetMapping
    @ResponseBody
    public UsersResponseDto findAll(){
        return usersService.findAllDto();
    }

    @GetMapping("/{id}")
	@ResponseBody
    public UsersResponseDto findById (@PathVariable(name = "id") Long id){
        return usersService.findByIdDto(id);
    }

    @PostMapping
    @ResponseBody
    public UsersResponseDto saveUser (@RequestBody UsersDto usersDto){
        return usersService.saveUserDto(usersDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public UsersResponseDto deleteUser (@PathVariable(name = "id") Long id) {
        return usersService.deteleUserDto(id);
    }
}
