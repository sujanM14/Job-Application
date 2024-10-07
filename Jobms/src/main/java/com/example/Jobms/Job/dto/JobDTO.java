package com.example.Jobms.Job.dto;

import java.util.List;
import com.example.Jobms.Job.External.Company;
import com.example.Jobms.Job.External.Review;

public class JobDTO {
 
    
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalaray;
    private String location;
    private Company company;
    private List<Review> reviews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalaray() {
        return maxSalaray;
    }

    public void setMaxSalaray(String maxSalaray) {
        this.maxSalaray = maxSalaray;
    }

    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    public List<Review> getReview() {
        return reviews;
    }

    public void setReview(List<Review> reviews) {
        this.reviews = reviews;
    }
}
