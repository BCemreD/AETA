package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.CourseDto;

import java.util.List;

public interface ICourseService {
    List<CourseDto> getCoursesByTag(Long tagId);
    CourseDto getCourseById(Long id);
    List<CourseDto> getAllCourses();
    List<CourseDto> getCoursesByCategory(Long categoryId);

}