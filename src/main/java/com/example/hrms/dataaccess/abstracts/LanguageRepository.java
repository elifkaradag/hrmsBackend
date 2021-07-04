package com.example.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entity.concrete.Language;
import com.example.hrms.entity.concrete.ProgrammingLanguage;

public interface LanguageRepository extends JpaRepository<Language, Integer>{
	List<Language> getByCandidateId(int id);
}
