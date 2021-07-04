package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateCheckService;
import com.example.hrms.dataaccess.abstracts.CandidateRepository;
import com.example.hrms.entity.concrete.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService{

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public boolean existEmailCheck(Candidate candidate) {
		candidate.setEmail(candidate.getEmail().toLowerCase());
		List<Candidate> emails = candidateRepository.findByEmail(candidate.getEmail());

		if(emails.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean existIdentityCheck(Candidate candidate) {
		List<Candidate> identities = candidateRepository.findByIdentity(candidate.getIdentity());

		if(identities.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean passwordConfirmCheck(Candidate candidate) {
		if(candidate.getPassword().equals(candidate.getConfirmPassword()))
			return true;
		else
			return false;
	}

	@Override
	public boolean isEmptyCheck(Candidate candidate) {
		if (candidate.getEmail().strip().isEmpty()
				|| candidate.getPassword().strip().isEmpty()
				|| candidate.getFirstName().strip().isEmpty()
				|| candidate.getLastName().strip().isEmpty()
				|| candidate.getIdentity().strip().isEmpty()
				|| candidate.getYearOfBirth().toString().strip().isEmpty())
		{
			return false;
		}
		return true;
	}

}
