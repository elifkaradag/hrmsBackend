package com.example.HRMS.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.EmployerCheckService;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataaccess.abstracts.EmployerRepository;
import com.example.HRMS.entity.concrete.Candidate;
import com.example.HRMS.entity.concrete.Employer;

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
