package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataaccess.abstracts.JobTitleRepository;
import com.example.hrms.entity.concrete.Candidate;
import com.example.hrms.entity.concrete.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	@Autowired
	private JobTitleRepository jobTitleRepository;

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(jobTitleRepository.findAll(), "Veri Listelendi");

	}
	@Override
	public Result add(JobTitle JobTitle) {
		JobTitle.setName(JobTitle.getName().toLowerCase());
		List<JobTitle> alljobPositions = jobTitleRepository.findByName(JobTitle.getName());

		if(alljobPositions.size() != 0) {
			return new ErrorResult("Title already exist!");
		}
		else {
			jobTitleRepository.save(JobTitle);
			return new SuccessResult("Job Title added!");
		}
		
	}

}
