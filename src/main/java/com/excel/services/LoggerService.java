package com.excel.services;


public class LoggerService {
	private static int counter;
	
	public LoggerService(){
		counter++;
	}
	
	public void log(String comment){
		System.out.println("USER COMMENT ----"+ comment);
		System.out.println("NO OF LoggerInstance CREATED ----"+ counter);
	}

}
