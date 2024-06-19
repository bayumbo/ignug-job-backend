package com.bolsaempleo.backend.app.services;

import java.util.List;

import com.bolsaempleo.backend.app.entities.job_board.CompanyProfessional;

public interface CompanyProfessionalService {

    List<CompanyProfessional> findAll();
}
