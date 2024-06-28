package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.CoursDto;
import com.bolsaempleo.backend.app.dto.CoursResponseDto;
import com.bolsaempleo.backend.app.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursController {

    private final CoursService coursService;

    @Autowired
    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping
    public ResponseEntity<List<CoursResponseDto>> getAllCourses() {
        List<CoursResponseDto> courses = coursService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursResponseDto> getCourseById(@PathVariable Long id) {
        CoursResponseDto course = coursService.getCourseById(id);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CoursResponseDto> createCourse(@RequestBody CoursDto coursDto) {
        CoursResponseDto createdCourse = coursService.createOrUpdateCourse(coursDto);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoursResponseDto> updateCourse(@PathVariable Long id, @RequestBody CoursDto coursDto) {
        coursDto.setId(id); // Set the ID from path variable into DTO
        CoursResponseDto updatedCourse = coursService.createOrUpdateCourse(coursDto);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        coursService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
}

