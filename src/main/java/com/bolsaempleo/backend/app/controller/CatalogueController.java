package com.bolsaempleo.backend.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolsaempleo.backend.app.dto.CatalogueDto;
import com.bolsaempleo.backend.app.dto.CatalogueResponseDto;
import com.bolsaempleo.backend.app.entities.core.Catalogue;
import com.bolsaempleo.backend.app.services.CatalogueService;



@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @GetMapping
    public List<Catalogue> list(){
        return catalogueService.findAll();
    }

    @GetMapping("/{id}")
	@ResponseBody
    public CatalogueResponseDto findById (@PathVariable(name = "id") Long id){
        return catalogueService.findByIdDto(id);
    }
 
    @GetMapping("/tabla/{type}")
    @ResponseBody
    public CatalogueResponseDto findByType(@PathVariable("type") String type) {
        return catalogueService.findByTypeDes(type);
    }
     
	@PostMapping("/save")
	public CatalogueResponseDto save(@RequestBody CatalogueDto catalogueDto) {
		return catalogueService.saveCatalogue(catalogueDto);
	}
}
