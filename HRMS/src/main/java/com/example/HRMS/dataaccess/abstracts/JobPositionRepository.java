package com.example.HRMS.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entity.concrete.JobPosition;

public interface JobPositionRepository extends JpaRepository<JobPosition, Integer>{
	
}