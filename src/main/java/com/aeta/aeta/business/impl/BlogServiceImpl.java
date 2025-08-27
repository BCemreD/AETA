package com.aeta.aeta.business.impl;


import com.aeta.aeta.business.service.IBlogService;
import com.aeta.aeta.model.dto.BlogDto;
import com.aeta.aeta.model.entity.Blog;
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
        public List<BlogDto> getBlogsByTag(Long tagId) {
            List<Blog> blogs = blogRepository.findByTags_Name(tagId.toString());
            return blogs.stream()
                    .map(b -> BlogDto.builder()
                            .title(b.getTitle())
                            .imageSrc(b.getImageSrc())
                            .imageAlt(b.getImageAlt())
                            .url(b.getUrl())
                            .build())
                    .collect(Collectors.toList());
        }
    }


