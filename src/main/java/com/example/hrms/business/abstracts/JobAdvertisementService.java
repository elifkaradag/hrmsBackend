package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entity.concrete.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> getByIsActive();

	DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(int empyolerId);
	
	DataResult<JobAdvertisement> changeActivatedSituation(int advertId);
	
	DataResult<List<JobAdvertisement>> getBySortedDate();
	
	DataResult<JobAdvertisement> getById(int advertId);
	
	
	
	

}
