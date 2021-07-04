package com.example.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entity.concrete.JobAdvertisement;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> getByIsActive(boolean active);
	
	List<JobAdvertisement> getByIsActiveAndEmployerId(boolean active,int empyolerId);
	
	JobAdvertisement getByAdvertId(int id);
	
	

}
