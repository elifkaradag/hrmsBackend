package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entity.concrete.ProgrammingLanguage;
import com.example.hrms.entity.concrete.School;

public interface ProgrammingLanguageService {
	
    DataResult<List<ProgrammingLanguage>> getAll();
    DataResult<ProgrammingLanguage> add(ProgrammingLanguage programmingLanguage);

    DataResult<List<ProgrammingLanguage>> getByCandidateId(int id);
}
