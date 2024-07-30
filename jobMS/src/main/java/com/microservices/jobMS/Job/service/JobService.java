package com.microservices.jobMS.Job.service;

import com.microservices.jobMS.Job.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService
{
    List<Job> findAll();

    void createJob(Job job);

    Object getJobByid(Long id);

    Object deleteJobById(Long id);

    boolean updateJob(Long id, Job updateJob);
}
