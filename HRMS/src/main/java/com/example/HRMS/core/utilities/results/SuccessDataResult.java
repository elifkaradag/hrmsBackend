package com.example.HRMS.core.utilities.results;

public class SuccessDataResult<T> extends DataResult{

	public SuccessDataResult(T data, String message) {
		super(data, true ,message);
	}
	
	public SuccessDataResult(T data) {
		super(data, true);
	}
	
	public SuccessDataResult(String message) {
		super(message, true);
	}
	
	public SuccessDataResult() {
		super(null, true);
	}

}
