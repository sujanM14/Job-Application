package com.example.Jobms.Job;

import java.util.List;

import com.example.Jobms.Job.dto.JobDTO;

public interface JobService {
    List<JobDTO> FindAllJobs();
    void createJob(Job job);
    JobDTO getJobbyId(Long id);
    boolean deleteJob(Long id);
    boolean updateJobById(Long id, Job updatedJob);
    
    

}
