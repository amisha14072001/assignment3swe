package com.example.student_survey.service;

import com.example.student_survey.model.StudentSurvey;
import com.example.student_survey.repository.StudentSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSurveyService {
    @Autowired
    private StudentSurveyRepository studentSurveyRepository;

    public List<StudentSurvey> getAllSurveys() {
        return studentSurveyRepository.findAll();
    }

    public StudentSurvey saveSurvey(StudentSurvey survey) {
        return studentSurveyRepository.save(survey);
    }

    public Optional<StudentSurvey> getSurveyById(Long id) {
        return studentSurveyRepository.findById(id);
    }

    public StudentSurvey updateSurvey(StudentSurvey survey) {
        return studentSurveyRepository.save(survey);
    }

    public void deleteSurvey(Long id) {
        studentSurveyRepository.deleteById(id);
    }
}
