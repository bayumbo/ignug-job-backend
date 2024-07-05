package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto implements Serializable{


    private Long id;
    private Long activityTypeId;
    private Object commercialActivities;
    private String createdAt;
    private String deletedAt;
    private Long personTypeId;
    private String tradeName;
    private Long typeId;
    private String updatedAt;
    private Long userId;
    private String web;
}
