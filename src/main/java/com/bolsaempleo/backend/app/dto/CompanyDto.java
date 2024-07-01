package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

public class CompanyDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long activityTypeId;

    @Getter @Setter
    private Object commercialActivities;

    @Getter @Setter
    private String createdAt;

    @Getter @Setter
    private String deletedAt;

    @Getter @Setter
    private Long personTypeId;

    @Getter @Setter
    private String tradeName;

    @Getter @Setter
    private Long typeId;

    @Getter @Setter
    private String updatedAt;

    @Getter @Setter
    private Long userId;

    @Getter @Setter
    private String web;
}
