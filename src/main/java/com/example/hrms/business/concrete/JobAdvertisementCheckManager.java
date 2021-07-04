package com.example.hrms.business.concrete;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobAdvertisementCheckService;
import com.example.hrms.entity.concrete.JobAdvertisement;

@Service
public class JobAdvertisementCheckManager implements JobAdvertisementCheckService{

	@Override
	public boolean isEmptyCheck(JobAdvertisement jobAdvertisement) {

		if(jobAdvertisement.getCity() == null
				|| jobAdvertisement.getEmployer() == null
				|| jobAdvertisement.getJobDefinitation().isEmpty()
				|| jobAdvertisement.getDeadline() == null
				|| jobAdvertisement.getJobtitle() == null) {
			return false;
		}
		else if(jobAdvertisement.getQuota()<=0 
				|| jobAdvertisement.getMinSalary()<=0 
				|| jobAdvertisement.getMaxSalary()<=0 
				|| jobAdvertisement.getMinSalary() == jobAdvertisement.getMaxSalary())
		{
			return false;
		}
		return true;
	}

}