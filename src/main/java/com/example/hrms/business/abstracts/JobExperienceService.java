package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entity.concrete.JobExperience;
import com.example.hrms.entity.concrete.ProgrammingLanguage;

public interface JobExperienceService {
	
	DataResult<List<JobExperience>> getAll();
    DataResult<JobExperience> add(JobExperience jobExperience);
    
    DataResult<List<JobExperience>> getByCandidateId(int id);

}
