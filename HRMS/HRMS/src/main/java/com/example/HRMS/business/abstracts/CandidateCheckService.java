package com.example.HRMS.business.abstracts;

import com.example.HRMS.entity.concrete.Candidate;

public interface CandidateCheckService {
	
	boolean existEmailCheck(Candidate candidate);
	boolean existIdentityCheck(Candidate candidate);
	boolean passwordConfirmCheck(Candidate candidate);
	boolean isEmptyCheck(Candidate candidate);


}
