package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entity.concrete.JobTitle;

@RestController
@RequestMapping("api/hrms/")
public class JobTitlesController {
	
	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping("/jobtitles")
	public DataResult<List<JobTitle>> getAll(){
		
		return jobTitleService.getAll();
	}
	@PostMapping("/jobtitles")
	public Result add(@RequestBody JobTitle jobTitle){
		return jobTitleService.add(jobTitle);
	}

}
