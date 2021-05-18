package com.example.HRMS.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobPositionService;
import com.example.HRMS.dataaccess.abstracts.JobPositionRepository;
import com.example.HRMS.entity.concrete.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	@Autowired
	private JobPositionRepository jobPositionRepository;
	
	@Override
	public List<JobPosition> getAll() {
		return jobPositionRepository.findAll();
	}

}
