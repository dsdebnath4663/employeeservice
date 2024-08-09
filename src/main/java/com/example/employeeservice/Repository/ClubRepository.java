package com.example.employeeservice.Repository;

import com.example.employeeservice.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



    @Repository
    public interface ClubRepository extends JpaRepository<Club, Long> {
    }
