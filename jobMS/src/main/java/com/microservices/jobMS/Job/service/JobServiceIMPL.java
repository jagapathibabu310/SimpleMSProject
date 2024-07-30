package com.microservices.jobMS.Job.service;

import com.microservices.jobMS.Job.dao.JobRepository;
import com.microservices.jobMS.Job.external.Company;
import com.microservices.jobMS.Job.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceIMPL implements JobService
{
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> findAll()
    {
        RestTemplate restTemplate = new RestTemplate();
        Company company = restTemplate.getForObject("http://localhost:9092/companies/1", Company.class);
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job)
    {
        jobRepository.save(job);

    }

    @Override
    public Job getJobByid(Long id)
    {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Object deleteJobById(Long id)
    {
        try
        {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updateJob)
    {
        Optional<Job> jobOptional = jobRepository.findById(id);
         if (jobOptional.isPresent())
            {
                Job job = jobOptional.get();
                job.setTitle(updateJob.getTitle());
                job.setDescription(updateJob.getDescription());
                job.setMinSalary(updateJob.getMinSalary());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setLocation(updateJob.getLocation());
                jobRepository.save(job);
                return true;
            }

        return false;
    }
}
