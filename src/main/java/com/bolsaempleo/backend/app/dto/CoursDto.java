package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class CoursDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long certificationTypeId;

    @Getter @Setter
    private String createdAt;

    @Getter @Setter
    private String deletedAt;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private Date endedAt;

    @Getter @Setter
    private Integer hours;

    @Getter @Setter
    private String institution;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Date startedAt;

    @Getter @Setter
    private Long typeId;

    @Getter @Setter
    private Long areaId;

    @Getter @Setter
    private Long professionalId;
}
