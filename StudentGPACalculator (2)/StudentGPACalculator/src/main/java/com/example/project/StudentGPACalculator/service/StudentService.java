package com.example.project.StudentGPACalculator.service;

import com.example.project.StudentGPACalculator.model.Student;
import com.example.project.StudentGPACalculator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student login(String registrationNumber, String password) {
        Student student = studentRepository.findByRegistrationNumber(registrationNumber);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
