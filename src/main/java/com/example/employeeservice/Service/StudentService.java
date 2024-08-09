package com.example.employeeservice.Service;

import com.example.employeeservice.Repository.StudentRepository;
import com.example.employeeservice.exception.ResourceNotFoundException;
import com.example.employeeservice.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

//    public Student updateStudent(Long id, Student studentDetails) {
//        Student student = studentRepository.findById(id).orElse(null);
//        if (student != null) {
//            student.setName(studentDetails.getName());
//            student.setCourses(studentDetails.getCourses());
//            student.setClubs(studentDetails.getClubs());
//            return studentRepository.save(student);
//        }
//        return null;
//    }

    @Transactional
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

        student.setName(studentDetails.getName());
        student.setCourses(studentDetails.getCourses() != null ? studentDetails.getCourses() : student.getCourses());
//         if (studentDetails.getCourses() != null ){
//             student.setCourses(studentDetails.getCourses());
//         }
//         else {
//             student.setCourses(student.getCourses());
//         }
        student.setClubs(studentDetails.getClubs() != null ? studentDetails.getClubs() : student.getClubs());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
