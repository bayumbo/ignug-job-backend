
package com.bolsaempleo.backend.app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.UsersDto;
import com.bolsaempleo.backend.app.dto.UsersResponseDto;
import com.bolsaempleo.backend.app.services.UsersService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
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
    public UsersResponseDto findById (@PathVariable(name = "id") UUID id){
        return usersService.findByIdDto(id);
    }

    @GetMapping("/username/{userName}")
    @ResponseBody 
    public UsersResponseDto findByUserName(@PathVariable(name = "userName") String userName){
        return usersService.findByUserName(userName);
    }
    
    @GetMapping("/mail/{mail}")
    @ResponseBody 
    public UsersResponseDto findByMail(@PathVariable(name = "mail") String mail){
        return usersService.findByMail(mail);
    }

    @PostMapping
    @ResponseBody
    public UsersResponseDto saveUser (@RequestBody UsersDto usersDto){
        return usersService.saveUserDto(usersDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public UsersResponseDto deleteUser (@PathVariable(name = "id") UUID id) {
        return usersService.deteleUserDto(id);
    }
}
