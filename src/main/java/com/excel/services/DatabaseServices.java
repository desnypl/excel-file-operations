package com.excel.services;

public interface DatabaseServices {
	public void saveData(int row, String column, String value, String operation);

	public void loadAllData();
}
