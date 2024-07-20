package com.example.project.StudentGPACalculator.repository;

import com.example.project.StudentGPACalculator.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByRegistrationNumber(String registrationNumber);
}
