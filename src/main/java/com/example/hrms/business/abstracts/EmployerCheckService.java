package com.example.hrms.business.abstracts;

import com.example.hrms.entity.concrete.Employer;

public interface EmployerCheckService {
	boolean existEmailCheck(Employer employer);
	boolean mailDomainCheck(Employer employer);
	boolean isEmptyCheck(Employer employer);

}
