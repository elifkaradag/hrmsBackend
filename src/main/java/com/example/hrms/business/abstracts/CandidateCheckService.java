package com.example.hrms.business.abstracts;

import com.example.hrms.entity.concrete.Candidate;

public interface CandidateCheckService {
	
	boolean existEmailCheck(Candidate candidate);
	boolean existIdentityCheck(Candidate candidate);
	boolean passwordConfirmCheck(Candidate candidate);
	boolean isEmptyCheck(Candidate candidate);


}
