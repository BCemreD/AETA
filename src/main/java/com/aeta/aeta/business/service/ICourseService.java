package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.CourseDto;

import java.util.List;

public interface ICourseService {
    List<CourseDto> getCoursesByTag(Long tagId); // Parametreyi Long tagId olarak değiştirdik
    CourseDto getCourseById(Long id);
    List<CourseDto> getAllCourses();
}