package com.example.student_survey.repository;

import com.example.student_survey.model.StudentSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSurveyRepository extends JpaRepository<StudentSurvey, Long> {
    // Basic CRUD operations are provided by JpaRepository.
}
