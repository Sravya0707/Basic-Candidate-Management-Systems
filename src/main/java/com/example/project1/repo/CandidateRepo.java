package com.example.project1.repo;

import com.example.project1.entity.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidates,Long> {
}
