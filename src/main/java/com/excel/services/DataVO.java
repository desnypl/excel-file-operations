package com.excel.services;

public class DataVO {
	private String column;
	private Integer row;
	private String value;
	private String operation;
	
	public DataVO(String column,Integer row,String value, String operation){
		this.column = column;
		this.row = row;
		this.value = value;
		this.operation = operation;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	
	

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "DataVO [column=" + column + ", row=" + row + ", value=" + value
				+ ", operation=" + operation + "]";
	}
	
	

}
