package com.example.Jobms.Job.mapper;
import com.example.Jobms.Job.External.Company;
import com.example.Jobms.Job.External.Review;
import com.example.Jobms.Job.dto.JobDTO;

import java.util.List;

import com.example.Jobms.Job.Job;
public class jobMapper {
    public static JobDTO mapToJobDTO(Job job,Company company,List<Review> reviews){
        JobDTO JobDTO=new JobDTO();
        JobDTO.setId(job.getId());
        JobDTO.setTitle(job.getTitle());
        JobDTO.setDescription(job.getDescription());
        JobDTO.setLocation(job.getLocation());
        JobDTO.setMaxSalaray(job.getMaxSalaray());
        JobDTO.setMinSalary(job.getMinSalary());
        JobDTO.setCompany(company);
        JobDTO.setReview(reviews);

        return JobDTO;
    }
}
