package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class LanguageResponseDto {

    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private LanguageDto language;
    @Getter
    @Setter
    private List<LanguageDto> subLanguages;

}
