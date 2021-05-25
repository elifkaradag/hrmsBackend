package com.example.HRMS.business.concrete;

import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.EmailCheckService;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.entity.concrete.User;
@Service
public class EmailCheckManager implements EmailCheckService{

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email has been sent successfully to: " + user.getEmail());
	}


}
