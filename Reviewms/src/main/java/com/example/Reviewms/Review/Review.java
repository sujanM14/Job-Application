package com.example.Reviewms.Review;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;


    private Long companyId;
    public Review() {
    }

    // Parameterized constructor
    public Review(Long id, String title, String description, double rating,Long companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.companyId=companyId;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setCompanyId(Long company) {
        this.companyId = company;
    }

    public Long getCompanyId() {
        return companyId;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}