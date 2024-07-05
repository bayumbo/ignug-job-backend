package com.bolsaempleo.backend.app.dto;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogueDto implements Serializable{

    private String code;
    private String color;
    private String createdAt;
    private String deletedAt;
    private String description;
    private String icon;
    private String name;
    private String type;
    private String updatedAt;
    private String catalogue;
}
