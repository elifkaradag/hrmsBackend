package com.example.HRMS.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entity.concrete.Employer;
import com.example.HRMS.entity.concrete.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer>{
	List<JobTitle> findByName(String name);
}