package com.example.project1.controller;

import com.example.project1.entity.Candidates;
import com.example.project1.repo.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Candidatecontroller {

    @Autowired
    CandidateRepo candidateRepo;

    @PostMapping("/api/candidate")
    public ResponseEntity<Candidates> savecandidate(@RequestBody Candidates candidate){
        return new ResponseEntity<>(candidateRepo.save(candidate), HttpStatus.CREATED);
    }

    @GetMapping("/api/candidate")
    public ResponseEntity<List<Candidates>> getCandidates() {
        return new ResponseEntity<>(candidateRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("/api/candidate/{id}")
    public ResponseEntity<Candidates> getCandidate(@PathVariable long id) {
        Optional<Candidates> candidate = candidateRepo.findById(id);
          if(candidate.isPresent()){
              return new ResponseEntity<>(candidate.get(), HttpStatus.OK);
          }
          else {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }


    @PutMapping("/api/candidate/{id}")
    public ResponseEntity<Candidates> getCandidate(@PathVariable long id, @RequestBody Candidates cand) {
        Optional<Candidates> candidate = candidateRepo.findById(id);
        if(candidate.isPresent()){
            candidate.get().setName(cand.getName());
            candidate.get().setEmail(cand.getEmail());
            candidate.get().setPhone(cand.getPhone());
            candidate.get().setCurrent_status(cand.getCurrent_status());
            candidate.get().setResume_link(cand.getResume_link());
            return new ResponseEntity<>(candidateRepo.save(candidate.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/candidate/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable long id) {
        Optional<Candidates> candidate = candidateRepo.findById(id);
        if(candidate.isPresent()){
            candidateRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
