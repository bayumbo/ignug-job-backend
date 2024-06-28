package com.bolsaempleo.backend.app.dto;

import java.util.Date;

public class AcademicFormationDto {
    private Long id;
    private Long careerId;
    private Boolean certificated;
    private Date registeredAt;
    private String senescytCode;
    private Long categoryId;
    private Long professionalId;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCareerId() {
        return careerId;
    }

    public void setCareerId(Long careerId) {
        this.careerId = careerId;
    }

    public Boolean getCertificated() {
        return certificated;
    }

    public void setCertificated(Boolean certificated) {
        this.certificated = certificated;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getSenescytCode() {
        return senescytCode;
    }

    public void setSenescytCode(String senescytCode) {
        this.senescytCode = senescytCode;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }
}
