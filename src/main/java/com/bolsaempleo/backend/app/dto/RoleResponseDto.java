package com.bolsaempleo.backend.app.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleResponseDto {

    private String code;
    private String message;
    private List<RoleDto> data;
}
