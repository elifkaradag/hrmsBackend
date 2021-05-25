package com.example.HRMS.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.CandidateCheckService;
import com.example.HRMS.business.abstracts.CandidateService;
import com.example.HRMS.business.abstracts.EmailCheckService;
import com.example.HRMS.core.adapters.MernisAdapter;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataaccess.abstracts.CandidateRepository;
import com.example.HRMS.entity.concrete.Candidate;

@Service
public class CandidateManager implements CandidateService{

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private CandidateCheckService candidateCheckService;
	@Autowired
	private MernisAdapter mernisAdapter;
	@Autowired
	private EmailCheckService emailCheckService;

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateRepository.findAll(), "Veri Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		//eposta ve mernis doğrulaması eksik
		if(!candidateCheckService.isEmptyCheck(candidate)) {
			return new ErrorResult("All fields must be filled!");
		}
		else if(!candidateCheckService.existEmailCheck(candidate)) {
			return new ErrorResult("Email already exist!");
		}
		else if(!candidateCheckService.existIdentityCheck(candidate)) {
			return new ErrorResult("Identity number already exist!");
		}
		else if(!candidateCheckService.passwordConfirmCheck(candidate)) {
			return new ErrorResult("Password did not match");
		}
		else if(!mernisAdapter.checkIfReal(candidate)) {
			return new ErrorResult("Not a real person!");
		}
		else {
			candidateRepository.save(candidate);
			return new SuccessResult(emailCheckService.sendEmail(candidate).getMessage());
		}
	}

}
