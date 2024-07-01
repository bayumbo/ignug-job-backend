package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class CourseDto {
    private Long id;
    private Long certificationTypeId;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    private String description;
    private Date endedAt;
    private Integer hours;
    private String institution;
    private String name;
    private Date startedAt;
    private Long typeId;
    private Timestamp updatedAt;
    private Long areaId; 
    private Long professionalId; 
}

