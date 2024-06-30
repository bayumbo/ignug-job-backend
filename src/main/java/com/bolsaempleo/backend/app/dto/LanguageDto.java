package com.bolsaempleo.backend.app.dto;

public class LanguageDto {
    private Long idiomId;
    private Long readLevelId;
    private Long spokenLevelId;
    private Long writtenLevelId;
    private Long professionalId;

    public Long getIdiomId() {
        return idiomId;
    }

    public void setIdiomId(Long idiomId) {
        this.idiomId = idiomId;
    }

    public Long getReadLevelId() {
        return readLevelId;
    }

    public void setReadLevelId(Long readLevelId) {
        this.readLevelId = readLevelId;
    }

    public Long getSpokenLevelId() {
        return spokenLevelId;
    }

    public void setSpokenLevelId(Long spokenLevelId) {
        this.spokenLevelId = spokenLevelId;
    }

    public Long getWrittenLevelId() {
        return writtenLevelId;
    }

    public void setWrittenLevelId(Long writtenLevelId) {
        this.writtenLevelId = writtenLevelId;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }
}
