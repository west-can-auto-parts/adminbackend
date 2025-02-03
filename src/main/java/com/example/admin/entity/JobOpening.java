package com.example.admin.entity;

import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "JobOpening")
public class JobOpening {
    private String id;
    private String jobTitle;
    private String location;
    private String company;
    private String jobDescription;
    private List<String> responsibilities;
    private List<String> qualifications;
    private String employmentType;
    private String salaryRange;
    private LocalDateTime applicationDeadline;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getJobTitle () {
        return jobTitle;
    }

    public void setJobTitle (String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation () {
        return location;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public String getCompany () {
        return company;
    }

    public void setCompany (String company) {
        this.company = company;
    }

    public String getJobDescription () {
        return jobDescription;
    }

    public void setJobDescription (String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public List<String> getResponsibilities () {
        return responsibilities;
    }

    public void setResponsibilities (List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    public List<String> getQualifications () {
        return qualifications;
    }

    public void setQualifications (List<String> qualifications) {
        this.qualifications = qualifications;
    }

    public String getEmploymentType () {
        return employmentType;
    }

    public void setEmploymentType (String employmentType) {
        this.employmentType = employmentType;
    }

    public String getSalaryRange () {
        return salaryRange;
    }

    public void setSalaryRange (String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public LocalDateTime getApplicationDeadline () {
        return applicationDeadline;
    }

    public void setApplicationDeadline (LocalDateTime applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public LocalDateTime getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt () {
        return updatedAt;
    }

    public void setUpdatedAt (LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive () {
        return active;
    }

    public void setActive (boolean active) {
        this.active = active;
    }
}
