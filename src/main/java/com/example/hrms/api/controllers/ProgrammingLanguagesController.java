package com.example.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.business.abstracts.ProgrammingLanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entity.concrete.Language;
import com.example.hrms.entity.concrete.ProgrammingLanguage;
import com.example.hrms.entity.concrete.School;

@RestController
@RequestMapping("api/hrms/programminglanguages")
public class ProgrammingLanguagesController {

	@Autowired
	private ProgrammingLanguageService programmingLanguageService;

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = programmingLanguageService.getAll();

		if (!result.isSuccess()){
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ProgrammingLanguage programmingLanguage){
		var result = programmingLanguageService.add(programmingLanguage);
		
		if (!result.isSuccess()){
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getbycandidateid")
	public DataResult<List<ProgrammingLanguage>> getByCandidateId(@RequestParam int candidateId){
		return programmingLanguageService.getByCandidateId(candidateId);
	}
	
}
