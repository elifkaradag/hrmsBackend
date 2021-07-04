package com.example.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.business.abstracts.SchoolService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entity.concrete.JobAdvertisement;
import com.example.hrms.entity.concrete.School;

@RestController
@RequestMapping("api/hrms/schools")
@CrossOrigin
public class SchoolsController {
	
	@Autowired
	private SchoolService schoolService;

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = schoolService.getAll();

		if (!result.isSuccess()){
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody School school){
		var result = schoolService.add(school);
		if (!result.isSuccess()){
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getbycandidateid")
	public DataResult<List<School>> getByCandidateId(@RequestParam int candidateId){

		return schoolService.getByCandidateId(candidateId);
	}
	
	

}
