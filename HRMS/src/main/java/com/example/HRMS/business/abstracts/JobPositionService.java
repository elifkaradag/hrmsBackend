package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.entity.concrete.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();

}
