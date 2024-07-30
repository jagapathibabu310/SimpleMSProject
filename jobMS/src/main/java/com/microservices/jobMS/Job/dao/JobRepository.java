package com.microservices.jobMS.Job.dao;


import com.microservices.jobMS.Job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>
{
}
