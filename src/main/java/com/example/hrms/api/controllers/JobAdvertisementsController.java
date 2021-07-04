package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entity.concrete.Employer;
import com.example.hrms.entity.concrete.JobAdvertisement;

@RestController
@RequestMapping("api/hrms/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	@Autowired
	private JobAdvertisementService jobAdvertisementService;

	@GetMapping("/isactive")
	public DataResult<List<JobAdvertisement>> getByIsActive(){

		return jobAdvertisementService.getByIsActive();
	}

	@GetMapping("/isactivewithemployerid")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(@RequestParam int empyolerId){

		return jobAdvertisementService.getByIsActiveAndEmployerId(empyolerId);
	}
	
	@GetMapping("/getbysorteddate")
	public DataResult<List<JobAdvertisement>> getBySortedDate(){

		return jobAdvertisementService.getBySortedDate();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/changeActivatedSituation")
	public DataResult<JobAdvertisement> changeActivatedSituation(@RequestParam int advertId){
		return jobAdvertisementService.changeActivatedSituation(advertId);
		
	}
	@GetMapping("/getbyid")
	public DataResult<JobAdvertisement> getById(@RequestParam int advertId){
		return jobAdvertisementService.getById(advertId);
		
	}

}
