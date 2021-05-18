package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.JobPositionService;
import com.example.HRMS.entity.concrete.JobPosition;

@RestController
@RequestMapping("api/hrms/")
public class JobPositionsController {
	
	@Autowired
	private JobPositionService jobPositionService;
	
	@GetMapping("/jobpositions")
	public List<JobPosition> getAll(){
		
		return jobPositionService.getAll();
	}

}
