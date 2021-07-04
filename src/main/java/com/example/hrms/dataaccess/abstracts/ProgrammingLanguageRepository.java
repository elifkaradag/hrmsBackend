package com.example.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entity.concrete.ProgrammingLanguage;
import com.example.hrms.entity.concrete.School;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{

	List<ProgrammingLanguage> getByCandidateId(int id);

}
