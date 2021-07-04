package com.example.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entity.concrete.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
	
	List<Candidate> findByEmail(String email);
	List<Candidate> findByIdentity(String identity);
	

}
