package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class CategoryOfferDto implements Serializable{

    private Long id;
    private String createdAt;
    private String updatedAt;
    private Long categoryId;
    private Long offerId;
}
