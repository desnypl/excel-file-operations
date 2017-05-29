package com.excel.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelServicesImpl implements ExcelServices{
	
	DatabaseServices databaseServices= new DatabaseServicesImpl();

	@SuppressWarnings("deprecation")
	public String readExcelColumn(int row, String column, String filePath) {
		//TODO Logger Service
		 try {
			 
			 FileInputStream excelFile = new FileInputStream(new File(filePath));
			 Workbook workbook = null;
			 
			    if (filePath.endsWith("xlsx")) {
			        workbook = new XSSFWorkbook(excelFile);
			    } else if (filePath.endsWith("xls")) {
			        workbook = new HSSFWorkbook(excelFile);
			    } else {
			        throw new IllegalArgumentException("The specified file is not Excel file");
			    }
			 
	           
	             // workbook = new XSSFWorkbook(excelFile);
	            
	            Cell currentCell = workbook.getSheetAt(0).getRow(row).getCell(CellReference.convertColStringToIndex(column));

	           if(currentCell.getCellType()==Cell.CELL_TYPE_STRING){
                    System.out.print(currentCell.getStringCellValue() + "--");
                  //TODO Logger Service
                    databaseServices.saveData(row, column,currentCell.getStringCellValue(),"READ" );
	           }else if(currentCell.getCellType()==Cell.CELL_TYPE_NUMERIC){
                    System.out.print(currentCell.getNumericCellValue() + "--");
                  //TODO Logger Service
                    databaseServices.saveData(row, column,currentCell.getStringCellValue(),"READ" );
	           }
	           
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    
		return null;
	}

	public void writeExcelColumn(int row, String column, String value, String filePath) {
		//TODO Logger Service
		FileInputStream fsIP=null;
		try {
			//TODO Logger Service
			fsIP = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e2) {
			//TODO Logger Service
			e2.printStackTrace();
		}
		Workbook workbook = null;
		 
	    if (filePath.endsWith("xlsx")) {
	        try {
				workbook = new XSSFWorkbook(fsIP);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    } else if (filePath.endsWith("xls")) {
	        try {
	        	//TODO Logger Service
				workbook = new HSSFWorkbook(fsIP);
			} catch (IOException e) {
				//TODO Logger Service
				e.printStackTrace();
			}
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
		
      
		 Cell currentCell = workbook.getSheetAt(0).getRow(row).getCell(CellReference.convertColStringToIndex(column));
		//TODO Logger Service
		currentCell.setCellValue(value);
		 databaseServices.saveData(row, column,value,"WRITE" );
		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
             
            }

		
	}



