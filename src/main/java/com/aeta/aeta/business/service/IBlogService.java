package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.BlogDto;
import java.util.List;

public interface IBlogService {

    List<BlogDto> getAllBlogs();
    List<BlogDto> getBlogsByTag(Long tagId);
    List<BlogDto> getBlogsByCategory(Long categoryId);
    public List<BlogDto> searchBlogsByTagsOrCategories(List<Long> tagIds, List<Long> categoryIds);

}