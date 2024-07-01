package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.entities.job_board.Company;
import com.bolsaempleo.backend.app.repositories.CompanyRepository;
import com.bolsaempleo.backend.app.utility.FechasUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        return companyOptional.orElse(null);
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company update(Long id, Company company) {
        if (!companyRepository.existsById(id)) {
            return null;
        }
        company.setId(id);
        company.setUpdatedAt(FechasUtil.getFechaTimestamp());
        return companyRepository.save(company);
    }

    public boolean delete(Long id) {
        if (!companyRepository.existsById(id)) {
            return false;
        }
        companyRepository.deleteById(id);
        return true;
    }
}
