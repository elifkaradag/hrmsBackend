package com.example.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entity.concrete.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{
	
	List<School> getByCandidateId(int id);

}
