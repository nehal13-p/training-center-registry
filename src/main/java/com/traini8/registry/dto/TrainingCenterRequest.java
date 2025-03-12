package com.traini8.registry.dto;

import java.util.List;

import com.traini8.registry.model.Address;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TrainingCenterRequest {
    @NotBlank(message = "Center name is mandatory")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9]{12}$", message = "Center code must be 12 alphanumeric characters")
    private String centerCode;

    @Valid
    private Address address;

    private Integer studentCapacity;

    private List<String> coursesOffered;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact phone is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Contact phone must be 10 digits")
    private String contactPhone;

    // Getters and Setters
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

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
}