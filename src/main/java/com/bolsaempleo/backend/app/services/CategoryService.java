package com.bolsaempleo.backend.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bolsaempleo.backend.app.dto.CategoryModelDto;
import com.bolsaempleo.backend.app.dto.CategoryRespuestaDto;
import com.bolsaempleo.backend.app.entities.Category;
import com.bolsaempleo.backend.app.repositories.CategoryRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;

@Component
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
   
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

    public CategoryRespuestaDto findByIdDto (Long entrada){
        CategoryRespuestaDto categoryRespuestaDto = new CategoryRespuestaDto();
        List<CategoryModelDto> categoryModelDtos = new ArrayList<>();
        try {
            //Optional<Category> categories = new ArrayList<>();
            Category category = categoryRepository.findCategoriesById(entrada);
            List<Category> categories= categoryRepository.getSubCategoriesById(category);
            
            if ( categories!=null){
                categoryRespuestaDto.setCode(ComunEnum.CORRECTO.toString());
                categoryRespuestaDto.setMessage(ComunEnum.MENSAJECORRECTO.toString());
                for (Category c : categories ){
                    categoryModelDtos.add(crearModel(c));
                }
                categoryRespuestaDto.setSubCategories(categoryModelDtos);
                
                categoryRespuestaDto.setCategories(crearModel(category));
            }else {
                categoryRespuestaDto.setCode(ComunEnum.INCORRECTO.toString());
                categoryRespuestaDto.setMessage(ComunEnum.MENSAJEINCORRECTO.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
            categoryRespuestaDto.setCode(ComunEnum.INCORRECTO.toString());
            categoryRespuestaDto.setMessage(ComunEnum.MENSAJEINCORRECTO.toString());
        }

        return categoryRespuestaDto;
    }

    public CategoryModelDto crearModel (Category category){
        CategoryModelDto categoryModelDto = new CategoryModelDto();

        if (category.getId() != null){
            categoryModelDto.setId(category.getId().toString());
        }
        if (category.getName() != null){
            categoryModelDto.setName(category.getName());
        }
        if (category.getUpdatedAt() != null){
            categoryModelDto.setUpdatedAt(category.getUpdatedAt().toString());
        }
        if (category.getCode() != null){
            categoryModelDto.setCode(category.getCode());
        }
        if (category.getCategory() != null){
            categoryModelDto.setCategory(category.getCategory().getId().toString());
        }
        if (category.getCreatedAt() != null){
            categoryModelDto.setCreatedAt(category.getCreatedAt().toString());
        }
        if (category.getDeletedAt() != null){
            categoryModelDto.setDeletedAt(category.getCreatedAt().toString());
        }
        return categoryModelDto;
    }
    
    public CategoryModelDto crearModelPadre (Category category){
        CategoryModelDto categoryModelDto = new CategoryModelDto();

        if (category.getId() != null){
            categoryModelDto.setId(category.getId().toString());
        }
        if (category.getName() != null){
            categoryModelDto.setName(category.getName());
        }
        if (category.getUpdatedAt() != null){
            categoryModelDto.setUpdatedAt(category.getUpdatedAt().toString());
        }
        if (category.getCode() != null){
            categoryModelDto.setCode(category.getCode());
        }
        if (category.getCategory() != null){
            categoryModelDto.setCategory(category.getCategory().getId().toString());
        }
        if (category.getCreatedAt() != null){
            categoryModelDto.setCreatedAt(category.getCreatedAt().toString());
        }
        if (category.getDeletedAt() != null){
            categoryModelDto.setDeletedAt(category.getCreatedAt().toString());
        }
        return categoryModelDto;
    }
}
