package com.excel.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dataservice.DatabaseService;

import static com.dataservice.DatabaseService.conn;


public class MySqlDatabaseServiceImpl implements DatabaseServices {

	public static List<DataVO> dataCollection = new ArrayList<DataVO>();
	@Override
	public void saveData(int row, String column, String value, String operation) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
        if(!(DatabaseService.getInstance().conn==null)){
        	
        
		Statement stmt=null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}}
		ResultSet rs=null;
		try {
			 
			String sql1= "select * from mytable";
			//String sqlQuery = "INSERT INTO 'mytable'(pid,tid,rid,tspend,description) VALUE ('"+pid+"','"+tid+"','"+rid+"',"+tspent+",'"+des+"');";
	           //st = conn.createStatement();
			/*stmt.executeUpdate("INSERT INTO excelop ('data1','data2','Name','data3') "
                    + "VALUES ("+row+",'"+column+"','"+value+"','"+operation+"')");*/
			String query = " insert into excelop (data1, data2, Name,data3)"
			        + " values (?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setInt (1, row);
			      preparedStmt.setString (2,column);
			      preparedStmt.setString (3,value);
			      preparedStmt.setString (4,operation);

			      // execute the preparedstatement
			      preparedStmt.execute();
			rs=conn.createStatement().executeQuery(sql1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
	}

}
