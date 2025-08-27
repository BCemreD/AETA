package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.JobDto;

import java.util.List;

public interface IJobService {
    List<JobDto> getJobsByTag(Long tagId);
}
