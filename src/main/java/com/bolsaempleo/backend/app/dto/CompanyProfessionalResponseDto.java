package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class CompanyProfessionalResponseDto implements Serializable{


 
    @Getter
	@Setter
	private String code;
	@Getter
	@Setter
    private String message;
	@Getter
	@Setter
    private CompanyProfessionalModelDto  companyProfessional;
	@Getter
	@Setter
    private List<CompanyProfessionalModelDto> listCompanyProfessional;

}
