package com.example.employeeservice.controller;

import com.example.employeeservice.Service.StudentService;
import com.example.employeeservice.exception.ResourceNotFoundException;
import com.example.employeeservice.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long id) {
        Student student = studentService.getStudentById(id);
        return student != null ? ResponseEntity.ok().body(student) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long id,
//                                                 @Valid @RequestBody Student studentDetails) {
//        Student updatedStudent = studentService.updateStudent(id, studentDetails);
//        return updatedStudent != null ? ResponseEntity.ok().body(updatedStudent) : ResponseEntity.notFound().build();
//    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        try {
            Student updatedStudent = studentService.updateStudent(id, studentDetails);
            return ResponseEntity.ok(updatedStudent);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(value = "id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
