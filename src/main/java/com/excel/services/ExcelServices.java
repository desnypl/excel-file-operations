package com.excel.services;

public interface ExcelServices {
	public String readExcelColumn(Long row, String column, String filePath);
	public void writeExcelColumn(Long row, String column, String value, String filePath);
}
