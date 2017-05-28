package com.excel.services;

public interface ExcelServices {
	
	public String readExcelColumn(int row, String column, String filePath);
	public void writeExcelColumn(int row, String column, String value, String filePath);


}
