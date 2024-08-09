package com.example.employeeservice.controller;


import com.example.employeeservice.Service.ClubService;
import com.example.employeeservice.model.Club;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable(value = "id") Long id) {
        Club club = clubService.getClubById(id);
        return club != null ? ResponseEntity.ok().body(club) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Club createClub(@Valid @RequestBody Club club) {
        return clubService.createClub(club);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Club clubDetails) {
        Club updatedClub = clubService.updateClub(id, clubDetails);
        return updatedClub != null ? ResponseEntity.ok().body(updatedClub) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable(value = "id") Long id) {
        clubService.deleteClub(id);
        return ResponseEntity.ok().build();
    }


}
