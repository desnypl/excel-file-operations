package com.excel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dataservice.DatabaseService;
import com.excel.services.DatabaseServices;
import com.excel.services.ExcelServices;
import com.excel.services.LoggerService;;

public class Main {
	
	public static void main(String[] args) {
		LoggerService st = LoggerService.getInstance();
		DatabaseService data =DatabaseService.getInstance();
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("file:resource/applicationContext.xml");
		ExcelServices bean = (ExcelServices) context.getBean("excelServices");
		DatabaseServices bean1 = (DatabaseServices) context.getBean("mysqlDataServices");
		DatabaseServices bean2 = (DatabaseServices) context.getBean("databaseServices");
		
		bean.readExcelColumn(3, "B","E:/WORKSPACE/eclipseneon/logs/Book1.xlsx");
		bean.writeExcelColumn(3, "B","Anish", "E:/WORKSPACE/eclipseneon/logs/Book1.xlsx");
		//DatabaseServices dbServices = new DatabaseServicesImpl();
		//
		
		
		
		//DatabaseServices dbServices1= new MySqlDatabaseServiceImpl();
		bean1.loadAllData();
		//dbServices.loadAllData();
	}

}
