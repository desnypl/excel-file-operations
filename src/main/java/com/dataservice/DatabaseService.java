package com.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.excel.services.LoggerService;

public class DatabaseService {
	
private static DatabaseService databaseservice;

	
public static Connection conn;

private DatabaseService(){
	System.out.println("inside dataservice singleton");
	try {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/excel-operations","root","root");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

}

public static DatabaseService getInstance(){
	if(databaseservice ==null)
	{
		databaseservice =new DatabaseService();
		
	}
	return databaseservice;
}

}
