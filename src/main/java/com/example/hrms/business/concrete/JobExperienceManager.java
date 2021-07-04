package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataaccess.abstracts.JobExperienceRepository;
import com.example.hrms.entity.concrete.JobExperience;
import com.example.hrms.entity.concrete.ProgrammingLanguage;
@Service
public class JobExperienceManager implements JobExperienceService{

    @Autowired
	private JobExperienceRepository jobExperienceRepository;

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceRepository.findAll());
    }

    @Override
    public DataResult<JobExperience> add(JobExperience jobExperience) {
        return new SuccessDataResult<JobExperience>(this.jobExperienceRepository.save(jobExperience));
    }
    
	@Override
	public DataResult<List<JobExperience>> getByCandidateId(int id) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceRepository.getByCandidateId(id));
	}
}
