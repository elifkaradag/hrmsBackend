package com.example.hrms.business.concrete;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmailCheckService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entity.concrete.User;
@Service
public class EmailCheckManager implements EmailCheckService{

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email has been sent successfully to: " + user.getEmail());
	}


}
