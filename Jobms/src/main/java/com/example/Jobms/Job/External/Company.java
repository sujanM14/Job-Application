package com.example.Jobms.Job.External;



public class Company {

    private Long id;
    private String name;
    private String description;
    

    public Company(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        
        
    }
   
    // Default Constructor
    public Company() {}

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

}

