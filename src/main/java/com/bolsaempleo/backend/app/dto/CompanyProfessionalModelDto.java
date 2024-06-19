package com.bolsaempleo.backend.app.dto;


import lombok.Getter;
import lombok.Setter;

public class CompanyProfessionalModelDto {

    @Getter
    @Setter
    private String id;

	@Getter
    @Setter
    private String createdAt;

	@Getter
    @Setter
    private String stateId;

	@Getter
    @Setter
    private String updatedAt;

	@Getter
    @Setter
    private String company;

	@Getter
    @Setter
    private String professional;
}
