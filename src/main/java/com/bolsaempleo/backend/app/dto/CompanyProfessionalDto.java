package com.bolsaempleo.backend.app.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyProfessionalDto {

 
    private String id;
    private String createdAt;
    private String stateId;
    private String updatedAt;
    private String company;
    private String professional;
}
