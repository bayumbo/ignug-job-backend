package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class CategoryResponseDto implements Serializable{

    private static final long serialVersionUID = 6977507763706405105L;
    @Getter
	@Setter
	private String code;
	@Getter
	@Setter
    private String message;
	@Getter
	@Setter
    private CategoryDto  categories;
	@Getter
	@Setter
    private List<CategoryDto> subCategories;
}
