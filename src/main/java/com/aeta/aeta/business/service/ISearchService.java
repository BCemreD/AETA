package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.BlogDto;
import com.aeta.aeta.model.dto.CourseDto;

import java.util.List;

public interface ISearchService {

    List<CourseDto> searchCourses(String query);
    List<BlogDto> searchBlogs(String query);
}
