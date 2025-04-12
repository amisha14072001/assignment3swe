package com.example.student_survey.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "student_surveys")
public class StudentSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Required fields
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String streetAddress;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String zip;
    @Column(nullable = false)
    private String telephoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDate surveyDate;

    // Survey responses
    @Column(nullable = false)
    private String likedMost; // e.g., students, location, campus, atmosphere, dorm rooms, sports
    @Column(nullable = false)
    private String interestedThrough; // e.g., friends, television, Internet, other
    @Column(nullable = false)
    private String recommendationLikelihood; // e.g., Very Likely, Likely, Unlikely

    // Getters and Setters
    // (or use Lombok @Data for brevity)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getStreetAddress() {
        return streetAddress;
    }
    
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZip() {
        return zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDate getSurveyDate() {
        return surveyDate;
    }
    
    public void setSurveyDate(LocalDate surveyDate) {
        this.surveyDate = surveyDate;
    }
    
    public String getLikedMost() {
        return likedMost;
    }
    
    public void setLikedMost(String likedMost) {
        this.likedMost = likedMost;
    }
    
    public String getInterestedThrough() {
        return interestedThrough;
    }
    
    public void setInterestedThrough(String interestedThrough) {
        this.interestedThrough = interestedThrough;
    }
    
    public String getRecommendationLikelihood() {
        return recommendationLikelihood;
    }
    
    public void setRecommendationLikelihood(String recommendationLikelihood) {
        this.recommendationLikelihood = recommendationLikelihood;
    }
}
