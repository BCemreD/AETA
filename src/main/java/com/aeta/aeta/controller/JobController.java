package com.aeta.aeta.controller;

import com.aeta.aeta.business.service.IJobService;
import com.aeta.aeta.model.dto.JobDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final IJobService jobService;

    public JobController(IJobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/tag/{id}")
    public List<JobDto> getJobsByTag(@PathVariable Long id) {
        return jobService.getJobsByTag(id);
    }
}
