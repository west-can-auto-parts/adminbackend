package com.example.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "JobApplication")
public class JobApplicationDocument {
    private String id;
    private String applicantName;
    private String applicantEmail;
    private String phone;
    private String resume;
    private String coverLetter;
    private String positionApplied;
    private String location;
    private int experienceYears;
    private String status;
    private LocalDateTime appliedAt;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getApplicantName () {
        return applicantName;
    }

    public void setApplicantName (String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantEmail () {
        return applicantEmail;
    }

    public void setApplicantEmail (String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getResume () {
        return resume;
    }

    public void setResume (String resume) {
        this.resume = resume;
    }

    public String getCoverLetter () {
        return coverLetter;
    }

    public void setCoverLetter (String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getPositionApplied () {
        return positionApplied;
    }

    public void setPositionApplied (String positionApplied) {
        this.positionApplied = positionApplied;
    }

    public String getLocation () {
        return location;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public int getExperienceYears () {
        return experienceYears;
    }

    public void setExperienceYears (int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public LocalDateTime getAppliedAt () {
        return appliedAt;
    }

    public void setAppliedAt (LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
}
