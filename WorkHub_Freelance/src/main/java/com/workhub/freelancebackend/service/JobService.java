package com.workhub.freelancebackend.service;

import com.workhub.freelancebackend.entity.Job;

import java.util.List;

public interface JobService {
    Job postJob(Job job);
    List<Job> getAllJobs();
    List<Job> getJobsByClientId(Long clientId);
    List<Job> getJobsByStatus(String status);
}
