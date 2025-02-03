package com.example.admin.service.implementation;

import com.example.admin.dto.JobApplicationResponse;
import com.example.admin.dto.JobOpeningRequest;
import com.example.admin.dto.JobOpeningResponse;
import com.example.admin.entity.JobApplicationDocument;
import com.example.admin.entity.JobOpening;
import com.example.admin.repository.JobApplicationRepository;
import com.example.admin.repository.JobOpeningRepository;
import com.example.admin.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobOpeningRepository jobOpeningRepository;
    @Autowired
    private JobApplicationRepository repository;

    public JobOpeningResponse createJob(JobOpeningRequest jobOpeningRequest) {
        JobOpening job = new JobOpening();
        job.setJobTitle(jobOpeningRequest.getJobTitle());
        job.setLocation(jobOpeningRequest.getLocation());
        job.setCompany(jobOpeningRequest.getCompany());
        job.setJobDescription(jobOpeningRequest.getJobDescription());
        job.setResponsibilities(jobOpeningRequest.getResponsibilities());
        job.setQualifications(jobOpeningRequest.getQualifications());
        job.setEmploymentType(jobOpeningRequest.getEmploymentType());
        job.setSalaryRange(jobOpeningRequest.getSalaryRange());
        job.setApplicationDeadline(jobOpeningRequest.getApplicationDeadline());
        job.setCreatedAt(LocalDateTime.now());
        job.setUpdatedAt(LocalDateTime.now());
        job.setActive(jobOpeningRequest.isActive());

        JobOpening savedJob = jobOpeningRepository.save(job);
        return mapToResponse(savedJob);
    }

    public JobOpeningResponse updateJob(String id, JobOpeningRequest jobOpeningRequest) {
        Optional<JobOpening> existingJob = jobOpeningRepository.findById(id);

        if (existingJob.isEmpty()) {
            throw new RuntimeException("Job not found");
        }

        JobOpening job = existingJob.get();
        job.setJobTitle(jobOpeningRequest.getJobTitle());
        job.setLocation(jobOpeningRequest.getLocation());
        job.setCompany(jobOpeningRequest.getCompany());
        job.setJobDescription(jobOpeningRequest.getJobDescription());
        job.setResponsibilities(jobOpeningRequest.getResponsibilities());
        job.setQualifications(jobOpeningRequest.getQualifications());
        job.setEmploymentType(jobOpeningRequest.getEmploymentType());
        job.setSalaryRange(jobOpeningRequest.getSalaryRange());
        job.setApplicationDeadline(jobOpeningRequest.getApplicationDeadline());
        job.setUpdatedAt(LocalDateTime.now());
        job.setActive(jobOpeningRequest.isActive());

        JobOpening updatedJob = jobOpeningRepository.save(job);
        return mapToResponse(updatedJob);
    }

    public List<JobOpeningResponse> getAllJobs() {
        List<JobOpening> jobOpenings = jobOpeningRepository.findAll();

        return jobOpenings.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private JobOpeningResponse mapToResponse(JobOpening job) {
        JobOpeningResponse response = new JobOpeningResponse();
        response.setId(job.getId());
        response.setJobTitle(job.getJobTitle());
        response.setLocation(job.getLocation());
        response.setCompany(job.getCompany());
        response.setJobDescription(job.getJobDescription());
        response.setResponsibilities(job.getResponsibilities());
        response.setQualifications(job.getQualifications());
        response.setEmploymentType(job.getEmploymentType());
        response.setSalaryRange(job.getSalaryRange());
        response.setApplicationDeadline(job.getApplicationDeadline());
        response.setCreatedAt(job.getCreatedAt());
        response.setUpdatedAt(job.getUpdatedAt());
        response.setActive(job.isActive());

        return response;
    }
    @Override
    public void deleteJob(String id) {
        jobOpeningRepository.deleteById(id);
    }

    @Override
    public JobOpeningResponse getJobById(String id) {
        JobOpening job = jobOpeningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));

        return mapToResponse(job);
    }

    @Override
    public List<JobApplicationResponse> getAllApplications() {
        List<JobApplicationDocument> applications = repository.findAll();

        return applications.stream().map(application -> {
            JobApplicationResponse response = new JobApplicationResponse();
            response.setId(application.getId());
            response.setApplicantName(application.getApplicantName());
            response.setApplicantEmail(application.getApplicantEmail());
            response.setPhone(application.getPhone());
            response.setResume(application.getResume());
            response.setCoverLetter(application.getCoverLetter());
            response.setPositionApplied(application.getPositionApplied());
            response.setLocation(application.getLocation());
            response.setExperienceYears(application.getExperienceYears());
            response.setStatus(application.getStatus());
            response.setAppliedAt(application.getAppliedAt());
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public JobApplicationResponse getApplicationById (String id) {
        JobApplicationDocument jobApp = repository.findById(id).orElseThrow(() -> new RuntimeException("Job application not found"));

        // Map the JobApplicationDocument to a JobApplicationResponse
        JobApplicationResponse response = new JobApplicationResponse();
        response.setId(jobApp.getId());
        response.setApplicantName(jobApp.getApplicantName());
        response.setApplicantEmail(jobApp.getApplicantEmail());
        response.setPhone(jobApp.getPhone());
        response.setResume(jobApp.getResume());
        response.setCoverLetter(jobApp.getCoverLetter());
        response.setPositionApplied(jobApp.getPositionApplied());
        response.setLocation(jobApp.getLocation());
        response.setExperienceYears(jobApp.getExperienceYears());
        response.setStatus(jobApp.getStatus());
        response.setAppliedAt(jobApp.getAppliedAt());

        // Return the populated response
        return response;
    }
}
