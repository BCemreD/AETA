package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.CourseDto;

import java.util.List;

public interface ICareerPathService {
    List<CourseDto> getCoursesForCareerPath(Long careerPathId);
}
