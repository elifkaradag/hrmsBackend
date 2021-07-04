package com.example.hrms.business.abstracts;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entity.concrete.Language;
import com.example.hrms.entity.concrete.ProgrammingLanguage;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();
    DataResult<Language> add(Language language);
    
    DataResult<List<Language>> getByCandidateId(int id);
}
