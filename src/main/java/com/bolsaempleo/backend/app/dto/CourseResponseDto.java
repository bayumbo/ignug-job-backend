package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponseDto {
    private String code;
    private String message;
    private CourseDto courseDto;
    private List<CourseDto> listCourseDto;

    public void setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
    }

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public void setListCourseDto(List<CourseDto> listCourseDto) {
        this.listCourseDto = listCourseDto;
    }

    public List<CourseDto> getListCourseDto() {
        return listCourseDto;
    }
}
