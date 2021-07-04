package com.example.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.entity.concrete.City;

@RestController
@RequestMapping("api/hrms/cities")
@CrossOrigin
public class CitiesController {
	
	@Autowired
	private CityService cityService;

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = cityService.getAll();

		if (!result.isSuccess()){
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody City city){
		var result = cityService.add(city);
		
		if (!result.isSuccess()){
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

}
