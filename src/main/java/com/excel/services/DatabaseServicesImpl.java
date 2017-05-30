package com.excel.services;

import java.util.ArrayList;
import java.util.List;

public class DatabaseServicesImpl implements DatabaseServices{
	
	public static List<DataVO> dataCollection = new ArrayList<DataVO>();


	@Override
	public void saveData(int row, String column, String value, String operation) {
		 LoggerService.getInstance().log("Logger Inside savedata method");
		DataVO dataVO = new DataVO(column, row, value, operation);
		if(!(dataVO == null)){
			
			
				dataCollection.add(dataVO);
			
		
		}
		else{
			LoggerService.getInstance().log("dataVO inside save data is empty");	
		}
	}


	@Override
	public void loadAllData() {
		LoggerService.getInstance().log("Logger Inside loadAll method");
		for(DataVO datavo : dataCollection){
			System.out.println(datavo);
		}
		
	}

}
