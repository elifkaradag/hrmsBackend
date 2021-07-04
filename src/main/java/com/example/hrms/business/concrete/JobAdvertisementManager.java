package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobAdvertisementCheckService;
import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataaccess.abstracts.JobAdvertisementRepository;
import com.example.hrms.entity.concrete.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	@Autowired
	private JobAdvertisementRepository jobAdvertisementRepository;
	
	@Autowired
	private JobAdvertisementCheckService jobAdvertisementCheckService;

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementRepository.getByIsActive(true));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(int empyolerId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementRepository.getByIsActiveAndEmployerId(true,empyolerId));
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		if(!jobAdvertisementCheckService.isEmptyCheck(jobAdvertisement)) {
			return new ErrorResult("All fields must be filled!");
		}
		
		jobAdvertisementRepository.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added!!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getBySortedDate() {
		Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementRepository.findAll(sort),"Sorted");
	}

	@Override
	public DataResult<JobAdvertisement> changeActivatedSituation(int advertId) {
		
		JobAdvertisement getOneJobAdvertisementById = jobAdvertisementRepository.getByAdvertId(advertId);
		getOneJobAdvertisementById.setActive(false);
		jobAdvertisementRepository.save(getOneJobAdvertisementById);
		
		return new SuccessDataResult<JobAdvertisement>(getOneJobAdvertisementById);
		
	}
	
	@Override
	public DataResult<JobAdvertisement> getById(int advertId) {
		
		JobAdvertisement getOneJobAdvertisementById = jobAdvertisementRepository.getByAdvertId(advertId);
		
		return new SuccessDataResult<JobAdvertisement>(getOneJobAdvertisementById);
		
	}

}
