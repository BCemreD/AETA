package com.aeta.aeta.business.impl;

import com.aeta.aeta.business.service.ICourseService;
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
        public List<CourseDto> getCoursesByTag(String tag) {
            List<Course> courses = courseRepository.findByTags_Name(tag);
            return courses.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
        }

        @Override
        public CourseDto getCourseById(Long id) {
            Course course = courseRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
            return toDto(course);
        }

        @Override
        public List<CourseDto> getAllCourses() {
            return courseRepository.findAll().stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
        }

        private CourseDto toDto(Course course) {
            return CourseDto.builder()
                    .title(course.getTitle())
                    .imageSrc(course.getImageSrc())
                    .imageAlt(course.getImageAlt())
                    .build();
        }
    }


