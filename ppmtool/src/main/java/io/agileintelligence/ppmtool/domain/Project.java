package io.agileintelligence.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project Name is required!")
    private String projectName;

    @NotBlank(message = "Project Identifier is required!")
    @Size(min = 4, max = 5, message = "Please use 4 to 5 character")
    @Column(updatable = false, unique = true)
    private String projectIdentifer;

    @NotBlank(message = "Project Description is required!")
    private String description;

    @JsonFormat(pattern = "yyy-mm-dd")
    private Date start_date;

    @JsonFormat(pattern = "yyy-mm-dd")
    private Date end_date;

    @JsonFormat(pattern = "yyy-mm-dd")
    private Date create_At;

    @JsonFormat(pattern = "yyy-mm-dd")
    private Date update_At;

    @PrePersist
    protected void onCreate() {
        this.create_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.update_At = new Date();
    }

    public Project() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifer() {
        return this.projectIdentifer;
    }

    public void setProjectIdentifer(String projectIdentifer) {
        this.projectIdentifer = projectIdentifer;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return this.start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreate_At() {
        return this.create_At;
    }

    public void setCreate_At(Date create_At) {
        this.create_At = create_At;
    }

    public Date getUpdate_At() {
        return this.update_At;
    }

    public void setUpdate_At(Date update_At) {
        this.update_At = update_At;
    }

}
