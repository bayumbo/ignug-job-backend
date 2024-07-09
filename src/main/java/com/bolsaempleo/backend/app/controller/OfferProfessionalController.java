package com.bolsaempleo.backend.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bolsaempleo.backend.app.dto.LocationDto;
import com.bolsaempleo.backend.app.dto.LocationResponseDto;
import com.bolsaempleo.backend.app.dto.OfferProfessionalDto;
import com.bolsaempleo.backend.app.dto.OfferProfessionalResponseDto;
import com.bolsaempleo.backend.app.dto.OfferResponseDto;
import com.bolsaempleo.backend.app.services.OfferProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/OfferProfessional")
public class OfferProfessionalController {


    
    @Autowired
    private OfferProfessionalService offersProfessionalService;

    @GetMapping
    public ResponseEntity<OfferProfessionalResponseDto> getAll() {
        OfferProfessionalResponseDto responseDto = offersProfessionalService.findAll();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
     @GetMapping("/{id}")
    public ResponseEntity<OfferProfessionalResponseDto> getById(@PathVariable Long id) {
        OfferProfessionalResponseDto offerProfessionalResponseDto = offersProfessionalService.findById(id);
        HttpStatus status = offerProfessionalResponseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(offerProfessionalResponseDto, status);
    }

    @PostMapping
    public ResponseEntity<OfferProfessionalResponseDto> create(@RequestBody OfferProfessionalDto offerProfessionalDto) {
        OfferProfessionalResponseDto responseDto = offersProfessionalService.save(offerProfessionalDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferProfessionalResponseDto> update(@PathVariable Long id, @RequestBody OfferProfessionalDto offerProfessionalDto) {
        OfferProfessionalResponseDto responseDto = offersProfessionalService.update(id, offerProfessionalDto);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OfferProfessionalResponseDto> delete(@PathVariable Long id) {
        OfferProfessionalResponseDto responseDto = offersProfessionalService.deleteById(id);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

}
