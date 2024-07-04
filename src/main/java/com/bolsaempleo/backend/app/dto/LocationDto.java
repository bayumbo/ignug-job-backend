package com.bolsaempleo.backend.app.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LocationDto {
    private Long id;
    private String alpha2Code;
    private String alpha3Code;
    private String callingCode;
    private String capital;
    private String code;
    private String flag;
    private String name;
    private String region;
    private String subregion;
    private Object timezones;
    private String topLevelDomain;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Long parentId;
    private Long typeId;

}