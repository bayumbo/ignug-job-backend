package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.ProfessionalUserDto;
import com.bolsaempleo.backend.app.dto.ProfessionalUserResponseDto;

public interface ProfessionalUserService {

    ProfessionalUserResponseDto saveProfessionalUserDto(ProfessionalUserDto professionalUserDto);
}
