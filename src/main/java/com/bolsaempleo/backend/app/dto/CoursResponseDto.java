package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class CoursResponseDto implements Serializable {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long certificationTypeId;

    @Getter @Setter
    private Timestamp createdAt;

    @Getter @Setter
    private Timestamp deletedAt;

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
    private String categoryName;

    @Getter @Setter
    private String professionalName;
}
