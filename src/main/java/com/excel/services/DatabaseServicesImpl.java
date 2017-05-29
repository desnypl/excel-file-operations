package com.excel.services;

import java.util.List;

public class DatabaseServicesImpl implements DatabaseServices{
	
	public static List<DataVO> dataCollection;


	@Override
	public void saveData(int row, String column, String value, String operation) {
		//TODO Logger Service
		DataVO dataVO = new DataVO(column, row, value, operation);
		dataCollection.add(dataVO);
	}


	@Override
	public void loadAllData() {
		//TODO Logger Service
		for(DataVO datavo : dataCollection){
			System.out.println(datavo);
		}
		
	}

}
