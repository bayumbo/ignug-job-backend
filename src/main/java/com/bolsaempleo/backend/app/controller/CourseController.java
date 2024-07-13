package com.bolsaempleo.backend.app.controller;


import com.bolsaempleo.backend.app.dto.CourseDto;
import com.bolsaempleo.backend.app.dto.CourseResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Cours;
import com.bolsaempleo.backend.app.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Cours> list() {
        return courseService.findAll();
    }

    @GetMapping("/*")
    @ResponseBody
    public CourseResponseDto findAllDto(){
        return courseService.findAllDto();
    }

    @GetMapping("/{id}")
    public CourseResponseDto findById(@PathVariable(name = "id") UUID id) {
        return courseService.findById(id);
    }

    @PostMapping("/save")
    public CourseResponseDto save(@RequestBody CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable(name = "id") UUID id) {
        courseService.deleteCourse(id);
    }
    /* 
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ObjectResponse> getAllCourses() {
        List<CourseResponseDto> courses = courseService.getAllCourses();
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setData(courses);
        return new ResponseEntity<ObjectResponse>(objectResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectResponse> getCourseById(@PathVariable Long id) {
        CourseResponseDto course = courseService.getCourseById(id);
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setData(course);
        return course != null ? ResponseEntity.ok(objectResponse) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseDto courseDto) {
        CourseResponseDto createdCourse = courseService.createOrUpdateCourse(courseDto);
        
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        coursDto.setId(id); // Set the ID from path variable into DTO
        CourseResponseDto updatedCourse = courseService.createOrUpdateCourse(courseDto);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }*/
}
