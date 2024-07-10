package com.bolsaempleo.backend.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bolsaempleo.backend.app.dto.CategoryDto;
import com.bolsaempleo.backend.app.dto.CategoryResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Category;
import com.bolsaempleo.backend.app.repositories.CategoryRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import com.bolsaempleo.backend.app.utility.FechasUtil;

@Component
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
   
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

    public CategoryResponseDto findByIdDto (Long entrada){
        CategoryResponseDto categoryRespuestaDto = new CategoryResponseDto();
        try {
            Category category = categoryRepository.findCategoryById(entrada);
            if ( category!=null){
                categoryRespuestaDto.setCode(ComunEnum.CORRECTO.toString());
                categoryRespuestaDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                categoryRespuestaDto.setData(crearModel(category));
            }else {
                categoryRespuestaDto.setCode(ComunEnum.INCORRECTO.toString());
                categoryRespuestaDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            }
        } catch (Exception e) {
            categoryRespuestaDto.setCode(ComunEnum.INCORRECTO.toString());
            categoryRespuestaDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
        }

        return categoryRespuestaDto;
    }

    public CategoryDto crearModel (Category category){
        CategoryDto categoryModelDto = new CategoryDto();

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
    

    public CategoryResponseDto findBySubCategoryId (Long entrada){
        CategoryResponseDto categoryRespuestaDto = new CategoryResponseDto();
        List<CategoryDto> categoryModelDtos = new ArrayList<>();
        try {
            Category category = categoryRepository.findCategoryById(entrada);
            List<Category> categories= categoryRepository.getSubCategoriesById(category);
            if ( categories!=null){
                categoryRespuestaDto.setCode(ComunEnum.CORRECTO.toString());
                categoryRespuestaDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                for (Category c : categories ){
                    categoryModelDtos.add(crearModel(c));
                }
                categoryRespuestaDto.setData(categoryModelDtos);
            }else {
                categoryRespuestaDto.setCode(ComunEnum.INCORRECTO.toString());
                categoryRespuestaDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            }
        } catch (Exception e) {
            categoryRespuestaDto.setCode(ComunEnum.INCORRECTO.toString());
            categoryRespuestaDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
        }

        return categoryRespuestaDto;
    }
    public CategoryResponseDto findCategoryAndSubCategoriesByCategoryId (Long entrada){
        CategoryResponseDto categoryRespuestaDto = new CategoryResponseDto();
        List<CategoryDto> categoryModelDtos = new ArrayList<>();
        try {
            Category category = categoryRepository.findCategoryById(entrada);
            List<Category> cats = categoryRepository.getCategoriesAndSubCategoriesById(entrada,category);
            if ( cats!=null){
                categoryRespuestaDto.setCode(ComunEnum.CORRECTO.toString());
                categoryRespuestaDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                for (Category c : cats ){
                    categoryModelDtos.add(crearModel(c));
                }
                categoryRespuestaDto.setData(categoryModelDtos);
            }else {
                categoryRespuestaDto.setCode(ComunEnum.INCORRECTO.toString());
                categoryRespuestaDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            }
        } catch (Exception e) {
            categoryRespuestaDto.setCode(ComunEnum.INCORRECTO.toString());
            categoryRespuestaDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
        }
        return categoryRespuestaDto;
    }

    public Category update(Long id, Category category) {
        if (!categoryRepository.existsById(id)) {
            return null;
        }
        category.setId(id);
        category.setUpdatedAt(FechasUtil.getFechaTimestamp());
        return categoryRepository.save(category);
    }
}
