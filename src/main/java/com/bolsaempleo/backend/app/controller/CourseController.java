package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.CourseDto;
import com.bolsaempleo.backend.app.dto.CourseResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Cours;
import com.bolsaempleo.backend.app.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Cours> list() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public CourseResponseDto findById(@PathVariable(name = "id") Long id) {
        return courseService.findById(id);
    }

    @PostMapping("/save")
    public CourseResponseDto save(@RequestBody CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable(name = "id") Long id) {
        courseService.deleteCourse(id);
    }
}
