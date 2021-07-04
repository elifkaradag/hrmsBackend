package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.EmailCheckService;
import com.example.hrms.business.abstracts.EmployerCheckService;
import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataaccess.abstracts.EmployerRepository;
import com.example.hrms.entity.concrete.Candidate;
import com.example.hrms.entity.concrete.Employer;
import com.example.hrms.entity.concrete.JobAdvertisement;

@Service
public class EmployerManager implements EmployerService{

	@Autowired
	private EmployerRepository employerRepository;

	@Autowired
	private EmployerCheckService employerCheckService;
	
	@Autowired
	private EmailCheckService emailCheckService;

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerRepository.findAll(), "Veri Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		//eposta ve mernis doğrulaması eksik

		if(!employerCheckService.isEmptyCheck(employer)) {
			return new ErrorResult("All fields must be filled!");
		}
		else if(!employerCheckService.existEmailCheck(employer)) {
			return new ErrorResult("Email already exist!");
		}
		else if(!employerCheckService.mailDomainCheck(employer)) {
			return new ErrorResult("Mail and domain name are incompatible.");
		}
		else {
			employerRepository.save(employer);
			return new SuccessResult(emailCheckService.sendEmail(employer).getMessage());

		}
	}
}
