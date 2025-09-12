package com.aeta.aeta.business.impl;

import com.aeta.aeta.business.service.IBlogService;
import com.aeta.aeta.model.dto.BlogDto;
import com.aeta.aeta.model.entity.Blog;
import com.aeta.aeta.model.entity.relation.Category;
import com.aeta.aeta.model.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogDto> getAllBlogs() {

        return blogRepository.findAllWithTags().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BlogDto> getBlogsByTag(Long tagId) {

        List<Blog> blogs = blogRepository.findByTagsId(tagId);
        return blogs.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BlogDto> getBlogsByCategory(Long categoryId) {
        List<Blog> blogs = blogRepository.findByCategoriesId(categoryId);
        return blogs.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private BlogDto toDto(Blog blog) {
        return BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .imageSrc(blog.getImageSrc())
                .imageAlt(blog.getImageAlt())
                .url(blog.getUrl())
                .tags(blog.getTags().stream().map(tag -> tag.getName()).collect(Collectors.toSet()))
                .categories(blog.getCategories().stream()
                        .map(Category::getName)
                        .collect(Collectors.toSet()))
                .build();
    }
}