package com.bolsaempleo.backend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.CategoryResponseDto;
import com.bolsaempleo.backend.app.dto.ObjectResponse;
import com.bolsaempleo.backend.app.entities.job_board.Category;
import com.bolsaempleo.backend.app.repositories.CategoryRepository;
import com.bolsaempleo.backend.app.services.CategoryService;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
@Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    public CategoryResponseDto findById (@PathVariable(name = "id") Long id){
        return categoryService.findByIdDto(id);
    }

    @GetMapping("/SubCategory/{id}")
    public CategoryResponseDto findBySubCategoryId (@PathVariable(name = "id") Long id){
        return categoryService.findBySubCategoryId(id);
    }

    @GetMapping("/allCatagories/{id}")
    public CategoryResponseDto findCategoryAndSubCategoriesByCategoryId (@PathVariable(name = "id") Long id){
        return categoryService.findCategoryAndSubCategoriesByCategoryId(id);
    }

    @PostMapping("/save")    
    public ResponseEntity<?> create (@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(category));   
    } 
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ObjectResponse> delete(@PathVariable Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        ObjectResponse objectResponse = new ObjectResponse();
        if (category != null) {
            objectResponse.setData(category);
            return new ResponseEntity<ObjectResponse>(objectResponse, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
