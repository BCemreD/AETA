package com.aeta.aeta.business.impl;

import com.aeta.aeta.business.service.ICourseService;
import com.aeta.aeta.exception.ResourceNotFoundException;
import com.aeta.aeta.model.dto.CourseDto;
import com.aeta.aeta.model.entity.Course;
import com.aeta.aeta.model.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        // Yeni findAllWithTags() metodunu çağırıyoruz
        return courseRepository.findAllWithTags().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByTag(Long tagId) {
        List<Course> courses = courseRepository.findByTagsId(tagId);
        return courses.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        return toDto(course);
    }
    private CourseDto toDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .imageSrc(course.getImageSrc())
                .imageAlt(course.getImageAlt())
                .url(course.getUrl())
                .tags(course.getTags().stream().map(tag -> tag.getName()).collect(Collectors.toSet()))
                .build();
    }
}