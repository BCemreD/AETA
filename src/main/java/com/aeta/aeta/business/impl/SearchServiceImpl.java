package com.aeta.aeta.business.impl;

import com.aeta.aeta.business.service.ISearchService;
import com.aeta.aeta.model.dto.BlogDto;
import com.aeta.aeta.model.dto.CourseDto;
import com.aeta.aeta.model.entity.Blog;
import com.aeta.aeta.model.entity.Course;
import com.aeta.aeta.model.entity.relation.Category;
import com.aeta.aeta.model.entity.relation.Tag;
import com.aeta.aeta.model.repository.BlogRepository;
import com.aeta.aeta.model.repository.CategoryRepository;
import com.aeta.aeta.model.repository.CourseRepository;
import com.aeta.aeta.model.repository.TagRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchServiceImpl implements ISearchService {


    private final CourseRepository courseRepository;
    private final BlogRepository blogRepository;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;

    public SearchServiceImpl(CourseRepository courseRepository, BlogRepository blogRepository,
                             TagRepository tagRepository, CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.blogRepository = blogRepository;
        this.tagRepository = tagRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CourseDto> searchCourses(String query) {
        String lowerQuery = query.toLowerCase();

        // Tag and Category ID lists
        List<Long> matchingTagIds = tagRepository.findAll().stream()
                .filter(tag -> lowerQuery.contains(tag.getName().toLowerCase()))
                .map(Tag::getId)
                .collect(Collectors.toList());

        List<Long> matchingCategoryIds = categoryRepository.findAll().stream()
                .filter(cat -> lowerQuery.contains(cat.getName().toLowerCase()))
                .map(Category::getId)
                .collect(Collectors.toList());

        // Union logic: tag or category matches
        Set<Course> results = new HashSet<>();
        if (!matchingTagIds.isEmpty()) {
            results.addAll(courseRepository.findByTagsIdIn(matchingTagIds));
        }
        if (!matchingCategoryIds.isEmpty()) {
            results.addAll(courseRepository.findByCategoriesIdIn(matchingCategoryIds));
        }

        return results.stream()
                .map(this::toCourseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BlogDto> searchBlogs(String query) {
        String lowerQuery = query.toLowerCase();

        List<Long> matchingTagIds = tagRepository.findAll().stream()
                .filter(tag -> lowerQuery.contains(tag.getName().toLowerCase()))
                .map(Tag::getId)
                .collect(Collectors.toList());

        List<Long> matchingCategoryIds = categoryRepository.findAll().stream()
                .filter(cat -> lowerQuery.contains(cat.getName().toLowerCase()))
                .map(Category::getId)
                .collect(Collectors.toList());

        Set<Blog> results = new HashSet<>();
        if (!matchingTagIds.isEmpty()) {
            results.addAll(blogRepository.findByTagsIdIn(matchingTagIds));
        }
        if (!matchingCategoryIds.isEmpty()) {
            results.addAll(blogRepository.findByCategoriesIdIn(matchingCategoryIds));
        }

        return results.stream()
                .map(this::toBlogDto)
                .collect(Collectors.toList());
    }

    private CourseDto toCourseDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .imageSrc(course.getImageSrc())
                .imageAlt(course.getImageAlt())
                .url(course.getUrl())
                .tags(course.getTags().stream().map(Tag::getName).collect(Collectors.toSet()))
                .categories(course.getCategories().stream().map(Category::getName).collect(Collectors.toSet()))
                .build();
    }

    private BlogDto toBlogDto(Blog blog) {
        return BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .imageSrc(blog.getImageSrc())
                .imageAlt(blog.getImageAlt())
                .url(blog.getUrl())
                .tags(blog.getTags().stream().map(Tag::getName).collect(Collectors.toSet()))
                .categories(blog.getCategories().stream().map(Category::getName).collect(Collectors.toSet()))
                .build();
    }
}
