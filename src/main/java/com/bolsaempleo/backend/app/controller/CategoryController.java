package com.bolsaempleo.backend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.CategoryResponseDto;
import com.bolsaempleo.backend.app.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryResponseDto showCategoryAndSubCategoriesByCategoryId (@PathVariable(name = "id") Long id){
        return categoryService.findByIdDto(id);
    }
}
