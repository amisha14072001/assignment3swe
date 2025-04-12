package com.example.student_survey.controller;

import com.example.student_survey.model.StudentSurvey;
import com.example.student_survey.service.StudentSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/surveydb")
public class StudentSurveyController {
    @Autowired
    private StudentSurveyService studentSurveyService;

    // Create a new survey
    @PostMapping
    public ResponseEntity<StudentSurvey> createSurvey(@RequestBody StudentSurvey survey) {
        StudentSurvey savedSurvey = studentSurveyService.saveSurvey(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }

    // Get all surveys
    @GetMapping
    public ResponseEntity<List<StudentSurvey>> getAllSurveys() {
        return ResponseEntity.ok(studentSurveyService.getAllSurveys());
    }

    // Get survey by id
    @GetMapping("/{id}")
    public ResponseEntity<StudentSurvey> getSurveyById(@PathVariable Long id) {
        return studentSurveyService.getSurveyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update survey
    @PutMapping("/{id}")
    public ResponseEntity<StudentSurvey> updateSurvey(@PathVariable Long id, @RequestBody StudentSurvey surveyDetails) {
        return studentSurveyService.getSurveyById(id).map(existingSurvey -> {
            // update fields
            existingSurvey.setFirstName(surveyDetails.getFirstName());
            existingSurvey.setLastName(surveyDetails.getLastName());
            existingSurvey.setStreetAddress(surveyDetails.getStreetAddress());
            existingSurvey.setCity(surveyDetails.getCity());
            existingSurvey.setState(surveyDetails.getState());
            existingSurvey.setZip(surveyDetails.getZip());
            existingSurvey.setTelephoneNumber(surveyDetails.getTelephoneNumber());
            existingSurvey.setEmail(surveyDetails.getEmail());
            existingSurvey.setSurveyDate(surveyDetails.getSurveyDate());
            existingSurvey.setLikedMost(surveyDetails.getLikedMost());
            existingSurvey.setInterestedThrough(surveyDetails.getInterestedThrough());
            existingSurvey.setRecommendationLikelihood(surveyDetails.getRecommendationLikelihood());
  
            StudentSurvey updatedSurvey = studentSurveyService.updateSurvey(existingSurvey);
            return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete survey
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        return studentSurveyService.getSurveyById(id).map(survey -> {
            studentSurveyService.deleteSurvey(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
