package com.aeta.aeta.controller;

import com.aeta.aeta.business.service.ISearchService;
import com.aeta.aeta.model.dto.BlogDto;
import com.aeta.aeta.model.dto.CourseDto;
import com.aeta.aeta.model.dto.SearchRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins = "http://localhost:5173")
public class SearchController {

    private final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/courses")
    public List<CourseDto> searchCourses(@RequestBody SearchRequest request) {
        return searchService.searchCourses(request.getQuery());
    }

    @PostMapping("/blogs")
    public List<BlogDto> searchBlogs(@RequestBody SearchRequest request) {
        return searchService.searchBlogs(request.getQuery());
    }
}