package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entity.concrete.School;

public interface SchoolService {
	
    DataResult<List<School>> getAll();
    DataResult<School> add(School school);
    
    DataResult<List<School>> getByCandidateId(int id);

}
