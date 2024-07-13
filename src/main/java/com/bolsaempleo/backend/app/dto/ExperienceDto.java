package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class ExperienceDto implements Serializable{
    
    private UUID id;
    private String activities;
    private Long areaId;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    private String employer;
    private Date endedAt;
    private String position;
    private String reasonLeave;
    private Date startedAt;
    private Timestamp updatedAt;
    private Boolean worked;
    private UUID professionalId;
}