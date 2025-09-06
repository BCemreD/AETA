package com.aeta.aeta.controller;

import com.aeta.aeta.business.service.ICourseService;
import com.aeta.aeta.model.dto.CourseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/courses")
    @CrossOrigin(origins = "http://localhost:5173")
    public class CourseController {

        private final ICourseService courseService;

        public CourseController(ICourseService courseService) {
            this.courseService = courseService;
        }

        @GetMapping
        public List<CourseDto> getAllCourses() {
            return courseService.getAllCourses();
        }

        @GetMapping("/{id}")
        public CourseDto getCourseById(@PathVariable Long id) {
            return courseService.getCourseById(id);
        }

        @GetMapping("/tag/{tag}")
        public List<CourseDto> getCoursesByTag(@PathVariable Long tagId) {
            return courseService.getCoursesByTag(tagId);
        }
    }


