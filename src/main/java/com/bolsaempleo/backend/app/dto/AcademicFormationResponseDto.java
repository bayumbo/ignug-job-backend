package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class AcademicFormationResponseDto implements Serializable {
    private Long id;
    private Long careerId;
    private Boolean certificated;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    private Date registeredAt;
    private String senescytCode;
    private Timestamp updatedAt;
    private String categoryName;
    private String professionalName;


}
