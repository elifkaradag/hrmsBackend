package com.example.HRMS.core.adapters;

import org.springframework.stereotype.Service;

import com.example.HRMS.entity.concrete.Candidate;
@Service
public class MernisAdapter {

	public boolean checkIfReal(Candidate candidate) {

		if(candidate.getIdentity().length() != 11) {
			return false;
		}
		return true;
	}

}
