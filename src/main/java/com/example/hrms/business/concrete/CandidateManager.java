package com.example.hrms.business.concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateCheckService;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.EmailCheckService;
import com.example.hrms.core.adapters.MernisAdapter;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataaccess.abstracts.CandidateRepository;
import com.example.hrms.entity.abstracts.IEntity;
import com.example.hrms.entity.concrete.Candidate;

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
	@Autowired
	private ValidationManager validationManager;

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateRepository.findAll(), "Veri Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {

		Object l = new ArrayList<Object>();
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
		//runGetter(candidate);
		//return new SuccessResult();
	}

	public void runGetter(IEntity aClass)
	{
		List<Object> l = new ArrayList<Object>();
		System.out.println("Girdi");
		java.lang.reflect.Field[] fields = aClass.getClass().getFields();

		// MZ: Find the correct method
		for (java.lang.reflect.Field field : fields)
		{
			if(field.getName().endsWith("Name") && field != null){
				System.out.println(field);
				//ield.getType().equals("String") && 
			}

			System.out.println(field);
			l.add(field);
		}

	}

}
