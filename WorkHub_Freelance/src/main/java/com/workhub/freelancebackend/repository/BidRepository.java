package com.workhub.freelancebackend.repository;

import com.workhub.freelancebackend.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByJobId(Long jobId);
    List<Bid> findByFreelancerId(Long freelancerId);
    @Query("SELECT COUNT(b) FROM Bid b WHERE b.jobId IN :jobIds")
    int countBidsByClientJobs(@Param("jobIds") List<Long> jobIds);
    @Query("SELECT b FROM Bid b WHERE b.jobId IN (SELECT j.id FROM Job j WHERE j.clientId = :clientId)")
    List<Bid> findBidsByClientId(@Param("clientId") Long clientId);

}
