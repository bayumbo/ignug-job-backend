package com.bolsaempleo.backend.app.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.OfferDto;
import com.bolsaempleo.backend.app.dto.OfferResponseDto;
import com.bolsaempleo.backend.app.services.OffersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OffersServiceImpl offersService;

    
        @GetMapping
    public ResponseEntity<OfferResponseDto> getAllLocations() {
        OfferResponseDto responseDto = offersService.findAll();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
   
       @GetMapping("/{id}")
    public ResponseEntity<OfferResponseDto> getOfferById(@PathVariable Long id) {
        OfferResponseDto responseDto = offersService.findById(id);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

    @PostMapping
    public ResponseEntity<OfferResponseDto> createLocation(@RequestBody OfferDto offerDto) {
        OfferResponseDto responseDto = offersService.save(offerDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferResponseDto> updateLocation(@PathVariable Long id, @RequestBody OfferDto offerDto) {
        OfferResponseDto responseDto = offersService.update(id, offerDto);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OfferResponseDto> deleteLocation(@PathVariable Long id) {
        OfferResponseDto responseDto = offersService.deleteById(id);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }
}
