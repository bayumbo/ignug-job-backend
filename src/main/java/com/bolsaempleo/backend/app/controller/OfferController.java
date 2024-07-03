package com.bolsaempleo.backend.app.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.OfferResponseDto;
import com.bolsaempleo.backend.app.repositories.OffersRepository;
import com.bolsaempleo.backend.app.services.OffersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OffersServiceImpl offersService;

    @GetMapping
    @ResponseBody
    public OfferResponseDto findAll(){
        return offersService.findAllDto();
    }
   
}
