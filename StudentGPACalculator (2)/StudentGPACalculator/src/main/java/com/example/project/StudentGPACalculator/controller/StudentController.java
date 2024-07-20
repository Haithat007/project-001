package com.example.project.StudentGPACalculator.controller;

import com.example.project.StudentGPACalculator.dto.LoginRequest;
import com.example.project.StudentGPACalculator.model.Student;
import com.example.project.StudentGPACalculator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PostMapping("/login")
    public Student loginStudent(@RequestBody LoginRequest loginRequest) {
        Student student = studentRepository.findByRegistrationNumber(loginRequest.getRegistrationNumber());
        if (student != null && student.getPassword().equals(loginRequest.getPassword())) {
            return student;
        }
        return null;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
