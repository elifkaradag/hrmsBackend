package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entity.concrete.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();
	Result add(JobTitle jobtitle);

}
