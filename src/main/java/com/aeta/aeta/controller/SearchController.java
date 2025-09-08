package com.aeta.aeta.controller;

import com.aeta.aeta.business.service.ISearchService;
import com.aeta.aeta.model.dto.BlogDto;
import com.aeta.aeta.model.dto.CourseDto;
import com.aeta.aeta.model.dto.SearchRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins = "http://localhost:5173")
public class SearchController {

    private final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public Map<String, Object> searchAll(@RequestBody SearchRequest request) {
        List<CourseDto> courses = searchService.searchCourses(request.getQuery());
        List<BlogDto> blogs = searchService.searchBlogs(request.getQuery());

        Map<String, Object> response = new HashMap<>();
        response.put("courses", courses);
        response.put("blogs", blogs);
        response.put("botMessage", "Toplam " + (courses.size() + blogs.size()) + " sonuç bulundu.");

        return response;
    }

}