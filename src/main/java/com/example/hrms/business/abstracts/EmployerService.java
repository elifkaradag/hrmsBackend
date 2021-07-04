package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entity.concrete.Employer;
import com.example.hrms.entity.concrete.JobAdvertisement;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);

}