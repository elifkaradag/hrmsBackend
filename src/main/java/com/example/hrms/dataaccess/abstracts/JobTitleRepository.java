package com.example.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entity.concrete.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer>{
	List<JobTitle> findByName(String name);
}