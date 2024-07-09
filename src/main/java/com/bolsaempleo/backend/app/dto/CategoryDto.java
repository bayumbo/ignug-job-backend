package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto implements Serializable{

    private String id;
    private String code;
    private String createdAt;
    private String deletedAt;
    private String icon;
    private String name;
    private String updatedAt;
    private String category;

}
