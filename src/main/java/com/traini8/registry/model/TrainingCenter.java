package com.traini8.registry.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name is mandatory")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9]{12}$", message = "Center code must be 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    @CollectionTable(name = "courses_offered", joinColumns = @JoinColumn(name = "training_center_id"))
    @Column(name = "course")
    private List<String> coursesOffered;

    private Long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact phone is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Contact phone must be 10 digits")
    private String contactPhone;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCenterName() { return centerName; }
    public void setCenterName(String centerName) { this.centerName = centerName; }

    public String getCenterCode() { return centerCode; }
    public void setCenterCode(String centerCode) { this.centerCode = centerCode; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Integer getStudentCapacity() { return studentCapacity; }
    public void setStudentCapacity(Integer studentCapacity) { this.studentCapacity = studentCapacity; }

    public List<String> getCoursesOffered() { return coursesOffered; }
    public void setCoursesOffered(List<String> coursesOffered) { this.coursesOffered = coursesOffered; }

    public Long getCreatedOn() { return createdOn; }
    public void setCreatedOn(Long createdOn) { this.createdOn = createdOn; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    @PrePersist
    protected void onCreate() {
        createdOn = System.currentTimeMillis();
    }
}