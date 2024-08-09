package com.example.employeeservice.Service;

import com.example.employeeservice.Repository.ClubRepository;
import com.example.employeeservice.model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
        @Autowired
        private ClubRepository clubRepository;

        public List<Club> getAllClubs() {
            return clubRepository.findAll();
        }

        public Club getClubById(Long id) {
            return clubRepository.findById(id).orElse(null);
        }

        public Club createClub(Club club) {
            return clubRepository.save(club);
        }

        public Club updateClub(Long id, Club clubDetails) {
            Club club = clubRepository.findById(id).orElse(null);
            if (club != null) {
                club.setName(clubDetails.getName());
                club.setStudents(clubDetails.getStudents());
                return clubRepository.save(club);
            }
            return null;
        }

        public void deleteClub(Long id) {
            clubRepository

                    .deleteById(id);
        }
}
