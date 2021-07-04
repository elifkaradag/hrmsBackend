package com.example.hrms.business.concrete;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.hrms.business.abstracts.SchoolService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataaccess.abstracts.SchoolRepository;
import com.example.hrms.entity.concrete.JobAdvertisement;
import com.example.hrms.entity.concrete.School;
@Service
public class SchoolManager implements SchoolService{
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Override
    public DataResult<List<School>> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC,"finishDate");
        return new SuccessDataResult<>(this.schoolRepository.findAll(sort),"All schools sorted!!");
    }

    @Override
    public DataResult<School> add(School school) {
    	
    
    	if(school.getFinishDate() == null || school.getFinishDate().isBlank()) {
    		school.setFinishDate("Present");
    	}
  
        return new SuccessDataResult<School>(this.schoolRepository.save(school),"School added!!");
    }

	@Override
	public DataResult<List<School>> getByCandidateId(int id) {
		
		return new SuccessDataResult<List<School>>(schoolRepository.getByCandidateId(id));

	}
}
