package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class CourseDto implements Serializable{
    private UUID id;
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
    private UUID areaId; 
    private UUID professionalId; 
    
}

