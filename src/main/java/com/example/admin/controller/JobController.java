package com.example.admin.controller;

import com.example.admin.dto.JobApplicationResponse;
import com.example.admin.dto.JobOpeningRequest;
import com.example.admin.dto.JobOpeningResponse;
import com.example.admin.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("admin/api")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs/all")
    public ResponseEntity<List<JobOpeningResponse>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobOpeningResponse> getJobById(@PathVariable String id) {
        JobOpeningResponse job = jobService.getJobById(id);
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/jobs/create")
    public ResponseEntity<JobOpeningResponse> createJob(@RequestBody JobOpeningRequest jobPosting) {
        return ResponseEntity.ok(jobService.createJob(jobPosting));
    }

    @PutMapping("/jobs/edit/{id}")
    public ResponseEntity<JobOpeningResponse> updateJob(@PathVariable String id, @RequestBody JobOpeningRequest updatedJob) {
        return ResponseEntity.ok(jobService.updateJob(id, updatedJob));
    }

    @DeleteMapping("/jobs/delete/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable String id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/job-application/all")
    public ResponseEntity<List<JobApplicationResponse>> getAllApplications(){
        List<JobApplicationResponse> responses=jobService.getAllApplications();
        return ResponseEntity.ok().body(responses);
    }
    @GetMapping("/job-application/{id}")
    public ResponseEntity<JobApplicationResponse> getApplicationById(@PathVariable String id) {
        JobApplicationResponse response= jobService.getApplicationById(id);
        return ResponseEntity.ok().body(response);
    }
}