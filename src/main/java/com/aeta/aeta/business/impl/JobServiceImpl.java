package com.aeta.aeta.business.impl;

import com.aeta.aeta.business.service.IJobService;
import com.aeta.aeta.model.dto.JobDto;
import com.aeta.aeta.model.entity.Job;
import com.aeta.aeta.model.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements IJobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobDto> getJobsByTag(Long tagId) {
        List<Job> jobs = jobRepository.findByTags_Id(tagId);
        return jobs.stream()
                .map(j -> JobDto.builder()
                        .id(j.getId())
                        .title(j.getTitle())
                        .description(j.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}
