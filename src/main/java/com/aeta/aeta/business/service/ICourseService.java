package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.CourseDto;

import java.util.List;

public interface ICourseService {
    List<CourseDto> getCoursesByTag(String tag);
    CourseDto getCourseById(Long id);
    List<CourseDto> getAllCourses();
}
