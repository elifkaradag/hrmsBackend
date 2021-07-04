package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entity.concrete.User;

public interface EmailCheckService {
	 Result sendEmail(User user) ;

}
