package com.excel.services;


public class LoggerService {
	private static LoggerService logservice;
	
	private static int counter;
	
	
	
	private LoggerService() {
		counter++;
	}

public static LoggerService getInstance(){
	if(logservice ==null)
	{
		logservice =new LoggerService();
	}
	return logservice;
}

	public void log(String comment){
		System.out.println("USER COMMENT ----"+ comment);
		System.out.println("NO OF LoggerInstance CREATED ----"+ counter);
	}

}
