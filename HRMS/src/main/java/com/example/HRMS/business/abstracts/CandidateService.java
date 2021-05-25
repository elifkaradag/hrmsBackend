package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entity.concrete.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);

}
