package com.example.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entity.concrete.JobExperience;
import com.example.hrms.entity.concrete.ProgrammingLanguage;
import com.example.hrms.entity.concrete.School;

public interface JobExperienceRepository extends JpaRepository<JobExperience, Integer>{

	List<JobExperience> getByCandidateId(int id);

}
