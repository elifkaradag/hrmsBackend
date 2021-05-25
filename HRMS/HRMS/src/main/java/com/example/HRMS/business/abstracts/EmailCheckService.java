package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entity.concrete.User;

public interface EmailCheckService {
	 Result sendEmail(User user) ;

}
