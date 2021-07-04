package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.ProgrammingLanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataaccess.abstracts.LanguageRepository;
import com.example.hrms.dataaccess.abstracts.ProgrammingLanguageRepository;
import com.example.hrms.entity.concrete.Language;
import com.example.hrms.entity.concrete.ProgrammingLanguage;
import com.example.hrms.entity.concrete.School;
@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	@Autowired
	private  ProgrammingLanguageRepository  programmingLanguageRepository;

	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		return new SuccessDataResult<>(this.programmingLanguageRepository.findAll());
	}

	@Override
	public DataResult<ProgrammingLanguage> add(ProgrammingLanguage programmingLanguage) {
		return new SuccessDataResult<ProgrammingLanguage>(this.programmingLanguageRepository.save(programmingLanguage));
	}
	
	@Override
	public DataResult<List<ProgrammingLanguage>> getByCandidateId(int id) {
		return new SuccessDataResult<List<ProgrammingLanguage>>(programmingLanguageRepository.getByCandidateId(id));
	}

}
