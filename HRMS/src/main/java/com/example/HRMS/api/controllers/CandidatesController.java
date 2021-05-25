package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.CandidateService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entity.concrete.Candidate;

@RestController
@RequestMapping("api/hrms/")
public class CandidatesController {
	
	@Autowired
	private CandidateService candidateService;
	
	@GetMapping("/candidates")
	public DataResult<List<Candidate>> getAll(){
		
		return candidateService.getAll();
	}
	@PostMapping("/candidates")
	public Result add(@RequestBody Candidate candidate){
		return candidateService.add(candidate);
	}

}
