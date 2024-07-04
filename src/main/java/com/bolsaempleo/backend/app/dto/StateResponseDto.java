package com.bolsaempleo.backend.app.dto;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StateResponseDto {
    private Long id;
    private String code;
    private String name;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    private Timestamp updatedAt;

    
}
