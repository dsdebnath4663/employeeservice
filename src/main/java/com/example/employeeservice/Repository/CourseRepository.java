package com.example.employeeservice.Repository;

import com.example.employeeservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CourseRepository extends JpaRepository<Course, Long> {
    }

