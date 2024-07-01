package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

public class CategoryOfferDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String createdAt;

    @Getter @Setter
    private String updatedAt;

    @Getter @Setter
    private Long categoryId;

    @Getter @Setter
    private Long offerId;
}
