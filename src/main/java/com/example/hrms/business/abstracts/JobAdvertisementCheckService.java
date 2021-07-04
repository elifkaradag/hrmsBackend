package com.example.hrms.business.abstracts;

import com.example.hrms.entity.concrete.JobAdvertisement;

public interface JobAdvertisementCheckService {
	
	boolean isEmptyCheck(JobAdvertisement jobAdvertisement);

}
