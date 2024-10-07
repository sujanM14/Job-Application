package com.example.Jobms.Job.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Jobms.Job.External.Company;
@FeignClient(name = "Companyms")
public interface CompanyClient {
 
    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable("id") Long id);
    

} 
