package com.workhub.freelancebackend.repository;

import com.workhub.freelancebackend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByClientId(Long clientId);
    List<Job> findByStatus(String status); // For OPEN jobs (freelancer browsing)
	List<Job> findByAssignedFreelancerId(Long freelancerId);
}
