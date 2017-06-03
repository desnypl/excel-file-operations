package com.excel;

import com.dataservice.DatabaseService;
import com.excel.services.DatabaseServices;
import com.excel.services.DatabaseServicesImpl;
import com.excel.services.ExcelServices;
import com.excel.services.ExcelServicesImpl;
import com.excel.services.LoggerService;
import com.excel.services.MySqlDatabaseServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		LoggerService st = LoggerService.getInstance();
		DatabaseService data =DatabaseService.getInstance();
		ExcelServices eService = new ExcelServicesImpl();
		eService.readExcelColumn(3, "B","E:/WORKSPACE/eclipseneon/logs/Book1.xlsx");
		eService.writeExcelColumn(3, "B","Anish", "E:/WORKSPACE/eclipseneon/logs/Book1.xlsx");
		//DatabaseServices dbServices = new DatabaseServicesImpl();
		DatabaseServices dbServices1= new MySqlDatabaseServiceImpl();
		dbServices1.loadAllData();
		//dbServices.loadAllData();
	}

}
