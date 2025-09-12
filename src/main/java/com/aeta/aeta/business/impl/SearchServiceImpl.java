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
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
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
    public List<CourseDto> searchCourses(String query, List<Long> tagIds, List<Long> categoryIds) {
        Set<Course> results = new HashSet<>();
        String lowerQuery = (query != null) ? query.toLowerCase() : "";
        boolean isQueryPresent = !lowerQuery.isBlank();
        boolean areTagsPresent = tagIds != null && !tagIds.isEmpty();
        boolean areCategoriesPresent = categoryIds != null && !categoryIds.isEmpty();

        // Only prompt bar
        if (isQueryPresent && !areTagsPresent && !areCategoriesPresent) {
            // split words
            String[] keywords = lowerQuery.split("\\s+");
            Set<Long> foundTagIds = new HashSet<>();
            Set<Long> foundCategoryIds = new HashSet<>();

            // Search tag or catg for each word
            for (String keyword : keywords) {
                foundTagIds.addAll(tagRepository.findByNameContainingIgnoreCase(keyword)
                        .stream().map(Tag::getId).collect(Collectors.toList()));
                foundCategoryIds.addAll(categoryRepository.findByNameContainingIgnoreCase(keyword)
                        .stream().map(Category::getId).collect(Collectors.toList()));
            }

            // Search from title
            results.addAll(courseRepository.findByTitleContainingIgnoreCase(lowerQuery));

            // Search by tag or catg IDs
            if (!foundTagIds.isEmpty()) {
                results.addAll(courseRepository.findByTagsIdIn(foundTagIds.stream().toList()));
            }
            if (!foundCategoryIds.isEmpty()) {
                results.addAll(courseRepository.findByCategoriesIdIn(foundCategoryIds.stream().toList()));
            }
        }
        // prepared prompts
        else if (areTagsPresent) {
            results.addAll(courseRepository.findByTagsIdIn(tagIds));
        }
        else if (areCategoriesPresent) {
            results.addAll(courseRepository.findByCategoriesIdIn(categoryIds));
        }
        // nol filter
        else {
            results.addAll(courseRepository.findAll());
        }

        return results.stream()
                .map(this::toCourseDto)
                .toList();
    }

    @Override
    public List<BlogDto> searchBlogs(String query, List<Long> tagIds, List<Long> categoryIds) {
        Set<Blog> results = new HashSet<>();
        String lowerQuery = (query != null) ? query.toLowerCase() : "";
        boolean isQueryPresent = !lowerQuery.isBlank();
        boolean areTagsPresent = tagIds != null && !tagIds.isEmpty();
        boolean areCategoriesPresent = categoryIds != null && !categoryIds.isEmpty();

        if (isQueryPresent) {
            String[] keywords = lowerQuery.split("\\s+");
            Set<Long> foundTagIds = new HashSet<>();
            Set<Long> foundCategoryIds = new HashSet<>();

            for (String keyword : keywords) {
                foundTagIds.addAll(tagRepository.findByNameContainingIgnoreCase(keyword)
                        .stream().map(Tag::getId).collect(Collectors.toList()));
                foundCategoryIds.addAll(categoryRepository.findByNameContainingIgnoreCase(keyword)
                        .stream().map(Category::getId).collect(Collectors.toList()));
            }

            results.addAll(blogRepository.findByTitleContainingIgnoreCase(lowerQuery));

            if (!foundTagIds.isEmpty()) {
                results.addAll(blogRepository.findByTagsIdIn(foundTagIds.stream().toList()));
            }
            if (!foundCategoryIds.isEmpty()) {
                results.addAll(blogRepository.findByCategoriesIdIn(foundCategoryIds.stream().toList()));
            }
        }
        else if (areTagsPresent) {
            results.addAll(blogRepository.findByTagsIdIn(tagIds));
        }
        else if (areCategoriesPresent) {
            results.addAll(blogRepository.findByCategoriesIdIn(categoryIds));
        }
        else {
            results.addAll(blogRepository.findAll());
        }

        return results.stream()
                .map(this::toBlogDto)
                .toList();
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