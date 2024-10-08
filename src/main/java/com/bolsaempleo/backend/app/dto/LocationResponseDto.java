package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationResponseDto implements Serializable{
    private String code;
    private String message;
    private List<LocationDto> data;


}