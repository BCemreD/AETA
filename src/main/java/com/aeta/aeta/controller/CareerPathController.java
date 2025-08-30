package com.aeta.aeta.controller;

import com.aeta.aeta.business.service.ICareerPathService;
import com.aeta.aeta.model.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/careers")
@RequiredArgsConstructor
public class CareerPathController {

    private final ICareerPathService careerPathService;

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCourses(@PathVariable Long id) {
        return careerPathService.getCoursesForCareerPath(id);
    }
}
