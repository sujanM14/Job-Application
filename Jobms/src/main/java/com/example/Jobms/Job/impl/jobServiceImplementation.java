package com.example.Jobms.Job.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Jobms.Job.Job;
import com.example.Jobms.Job.JobRepository;
import com.example.Jobms.Job.JobService;
import com.example.Jobms.Job.External.Company;
import com.example.Jobms.Job.External.Review;
import com.example.Jobms.Job.clients.CompanyClient;
import com.example.Jobms.Job.clients.ReviewClient;
import com.example.Jobms.Job.dto.JobDTO;
import com.example.Jobms.Job.mapper.jobMapper;

@Service
public class jobServiceImplementation implements JobService {
    JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    private CompanyClient companyClient;
    private ReviewClient reviewClient;
    public jobServiceImplementation(JobRepository jobRepository, CompanyClient companyClient,ReviewClient reviewClient){
       this.jobRepository=jobRepository;
       this.companyClient=companyClient;
       this.reviewClient=reviewClient;
    }
    private long nextId=1L;

    @Override
    public List<JobDTO> FindAllJobs() {

        List<Job> jobs=jobRepository.findAll();
       return jobs.stream().map(this:: convertToJobDTO).collect(Collectors.toList());
    }

    private JobDTO convertToJobDTO(Job jb){

            // using static rest template but for dynamic we use loadbalanced resttemplate 
            // RestTemplate restTemplate=new RestTemplate();   // for dynamic we are using it from above -->use this only during sstatic 
           /*  
        //    using restTemplate for dynamic
           Company company=restTemplate.getForObject("http://Companyms:8081/companies/"+jb.getCompanyId(), Company.class);
            ResponseEntity<List<Review>> reviewResponse =restTemplate.exchange(
                "http://Reviewms:8083/reviews?companyId="+jb.getCompanyId(),HttpMethod.GET,null, new ParameterizedTypeReference<List<Review>>(){
            List<Review> reviews=reviewResponse.getBody();
            });*/

            // Using openFeign
            Company company=companyClient.getCompany(jb.getCompanyId());
            List<Review> reviews=reviewClient.getReviews(jb.getCompanyId());
            
            return jobMapper.mapToJobDTO(jb, company,reviews);
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobRepository.save(job);
    }



    @Override
    public JobDTO getJobbyId(Long id) {
        Job jb=jobRepository.findById(id).orElse(null);
        return convertToJobDTO(jb);
    }



    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id); 
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }



    @Override
    public boolean updateJobById(Long id,Job updatedJob) {
       Optional<Job> optionalJob=jobRepository.findById(id); 
            if(optionalJob.isPresent()){
                Job jb=optionalJob.get();
               jb.setDescription(updatedJob.getDescription());
               jb.setLocation(updatedJob.getLocation());
               jb.setMaxSalaray(updatedJob.getMaxSalaray());
               jb.setMinSalary(updatedJob.getMinSalary());
               jb.setTitle(updatedJob.getTitle());
               jobRepository.save(jb);
               return true;

            }
        
        return false;
    }
    
}
