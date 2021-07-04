package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataaccess.abstracts.LanguageRepository;
import com.example.hrms.entity.concrete.Language;
import com.example.hrms.entity.concrete.ProgrammingLanguage;
@Service
public class LanguageManager implements LanguageService{

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<>(this.languageRepository.findAll());
    }

    @Override
    public DataResult<Language> add(Language language) {
        return new SuccessDataResult<Language>(this.languageRepository.save(language));
    }
    
	@Override
	public DataResult<List<Language>> getByCandidateId(int id) {
		return new SuccessDataResult<List<Language>>(languageRepository.getByCandidateId(id));
	}
}
