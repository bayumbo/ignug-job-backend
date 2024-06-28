package com.bolsaempleo.backend.app.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class ExperienceDto {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Object activities;

    @Getter @Setter
    private Long areaId;

    @Getter @Setter
    private String employer;

    @Getter @Setter
    private Date endedAt;

    @Getter @Setter
    private String position;

    @Getter @Setter
    private String reasonLeave;

    @Getter @Setter
    private Date startedAt;

    @Getter @Setter
    private Boolean worked;

    @Getter @Setter
    private Long professionalId;
}
