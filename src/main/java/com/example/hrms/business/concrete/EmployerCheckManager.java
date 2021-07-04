package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerCheckService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataaccess.abstracts.EmployerRepository;
import com.example.hrms.entity.concrete.Candidate;
import com.example.hrms.entity.concrete.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService{

	@Autowired
	private EmployerRepository employerRepository;

	@Override
	public boolean existEmailCheck(Employer employer) {
		List<Employer> emails = employerRepository.findByEmail(employer.getEmail());

		if(emails.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean mailDomainCheck(Employer employer) {
		String[] arrOfStr = employer.getEmail().split("@");
		String domain = arrOfStr[1];

		if(employer.getUrl().contains(domain))
			return true;
		else
			return false;
	}

	@Override
	public boolean isEmptyCheck(Employer employer) {
		  if (employer.getEmail().strip().isEmpty()
		            || employer.getPassword().strip().isEmpty()
		            || employer.getCompanyName().strip().isEmpty()
		            || employer.getPhone().strip().isEmpty()
		            || employer.getUrl().strip().isEmpty())
		    {
		        return false;
		    }
		  return true;

	}
}
