package com.aeta.aeta.controller;

import com.aeta.aeta.business.service.IBlogService;
import com.aeta.aeta.model.dto.BlogDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/blogs")
    @CrossOrigin(origins = "http://localhost:5173")
    public class BlogController {

        private final IBlogService blogService;

        public BlogController(IBlogService blogService) {
            this.blogService = blogService;
        }

        @GetMapping
        public List<BlogDto> getAllBlogs() {
            return blogService.getAllBlogs();
        }

        @GetMapping("/tag/{id}")
        public List<BlogDto> getBlogsByTag(@PathVariable("id") Long tagId) {
            return blogService.getBlogsByTag(tagId);
        }

    }


