package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReferenceDto implements Serializable{

    private String contactEmail;
    private String contactName;
    private String contactPhone;
    private String institution;
    private String position;
}
