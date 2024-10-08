package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReferenceResponseDto implements Serializable{
    
    private UUID id;
    private String contactEmail;
    private String contactName;
    private String contactPhone;
    private String institution;
    private String position;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
