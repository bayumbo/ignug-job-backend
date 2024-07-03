package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.ObjectResponse;
import com.bolsaempleo.backend.app.entities.job_board.Company;
import com.bolsaempleo.backend.app.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<ObjectResponse> getAllCompanies() {
        List<Company> companies = companyService.findAll();
        ObjectResponse objectResponse= new ObjectResponse();
        objectResponse.setData(companies);
        return ResponseEntity.ok(objectResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectResponse> getCompanyById(@PathVariable Long id) {
        Company company = companyService.findById(id);
        ObjectResponse objectResponse = new ObjectResponse();
        if (company != null && company.getDeletedAt() ==null) {
            objectResponse.setData(company);
            return ResponseEntity.status(HttpStatus.CREATED).body(objectResponse);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        Company updatedCompany = companyService.update(id, company);
        if (updatedCompany != null) {
            return ResponseEntity.ok(updatedCompany);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        boolean deleted = companyService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
