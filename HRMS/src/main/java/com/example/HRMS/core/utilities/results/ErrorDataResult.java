package com.example.HRMS.core.utilities.results;

public class ErrorDataResult<T> extends DataResult{

	public ErrorDataResult(T data, String message) {
		super(data, false ,message);
	}
	
	public ErrorDataResult(T data) {
		super(data, false);
	}
	
	public ErrorDataResult(String message) {
		super(message, false);
	}
	
	public ErrorDataResult() {
		super(null, false);
	}

}
