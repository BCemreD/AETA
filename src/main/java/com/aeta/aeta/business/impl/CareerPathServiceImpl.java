package com.aeta.aeta.business.impl;

import com.aeta.aeta.business.service.ICareerPathService;
import com.aeta.aeta.model.dto.CourseDto;
import com.aeta.aeta.model.repository.CareerPathCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerPathServiceImpl implements ICareerPathService {

    private final CareerPathCourseRepository careerPathCourseRepository;

    @Override
    public List<CourseDto> getCoursesForCareerPath(Long careerPathId) {
        return careerPathCourseRepository.findByCareerPathIdOrderByOrderNoAsc(careerPathId)
                .stream()
                .map(cpc -> CourseDto.builder()
                        .id(cpc.getCourse().getId())
                        .title(cpc.getCourse().getTitle())
                        .imageSrc(cpc.getCourse().getImageSrc())
                        .imageAlt(cpc.getCourse().getImageAlt())
                        .url(cpc.getCourse().getUrl())
                        .build())
                .toList();
    }
}
