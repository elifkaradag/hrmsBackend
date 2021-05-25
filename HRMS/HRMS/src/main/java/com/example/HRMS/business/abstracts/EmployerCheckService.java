package com.example.HRMS.business.abstracts;

import com.example.HRMS.entity.concrete.Candidate;
import com.example.HRMS.entity.concrete.Employer;

public interface EmployerCheckService {
	boolean existEmailCheck(Employer employer);
	boolean mailDomainCheck(Employer employer);
	boolean isEmptyCheck(Employer employer);

}
