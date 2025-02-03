package com.example.admin.service;

import com.example.admin.dto.JobApplicationResponse;
import com.example.admin.dto.JobOpeningRequest;
import com.example.admin.dto.JobOpeningResponse;
import com.example.admin.entity.JobOpening;

import java.util.List;

public interface JobService {
    List<JobOpeningResponse> getAllJobs();
    JobOpeningResponse createJob(JobOpeningRequest jobOpeningRequest);
    JobOpeningResponse updateJob(String id, JobOpeningRequest jobOpeningRequest);
    void deleteJob(String id);
    JobOpeningResponse getJobById(String id);
    List<JobApplicationResponse> getAllApplications();
    JobApplicationResponse getApplicationById(String id);
}
