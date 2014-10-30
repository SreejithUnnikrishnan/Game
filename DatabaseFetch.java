//Created by Sreejith Unnikrishnan
// Java code for database fetch


package com.sree.gam.pkg;
import java.sql.*;
public class DatabaseFetch {
	final String DB_URL = "jdbc:db2://serverip/dbName";
	
	public String[] question(String table,String questionNum)throws SQLException{
			String[] query = new String[6];
			try{
				Connection conn = DriverManager.getConnection(DB_URL);
				System.out.println("Connection obtained");
				Statement stat = conn.createStatement();
				String sqlStatement = "select qst_no,question,option1,option2,option3,option4,answer from "+table+" where qst_id='"+questionNum+"'";
				ResultSet result = stat.executeQuery(sqlStatement);
				if(result.next()){
					query[0] = result.getString("question");
					query[1] = result.getString("option1");
					query[2] = result.getString("option2");
					query[3] = result.getString("option3");
					query[4] = result.getString("option4");
					query[5] = result.getString("answer");
				}
				conn.close();
				return query;
			}
			catch(Exception ex)
			{
				System.out.println("Error in connection: "+ex.getMessage());
			}
			return query;
		}
	
	public String[] login(String userid,String password){
		String[] user = new String[3];
		try{
			Connection conn = DriverManager.getConnection(DB_URL);
			System.out.println("Connection obtained");
			Statement stat = conn.createStatement();
			String sqlStatement = "select user_id,first_name,last_name from login where user_id= "+userid+" and password= "+password;
			ResultSet result = stat.executeQuery(sqlStatement);
			if(result.next()){
				user[0] = result.getString("user_id");
				user[1] = result.getString("first_name");
				user[2] = result.getString("last_name");
				
			}
			conn.close();
			return user;
		}
		catch(Exception ex)
		{
			System.out.println("Error in connection: "+ex.getMessage());
		}
		return user;
		
	}
	
	public boolean userIdFecth(String userid){
		try{
			Connection conn = DriverManager.getConnection(DB_URL);
			System.out.println("Connection obtained");
			Statement stat = conn.createStatement();
			String sqlStatement = "select user_id from login where user_id= "+userid;
			ResultSet result = stat.executeQuery(sqlStatement);
			if(result.next()){
				conn.close();
				return true;
			}
			else{
				conn.close();
				return false;
			}
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Error in connection: "+ex.getMessage());
			return false;
		}
		
	}
	
	public boolean loginInsert(String userid,String first,String last,String password){
		try{
			Connection conn = DriverManager.getConnection(DB_URL);
			System.out.println("Connection obtained");
			Statement stat = conn.createStatement();
			String sqlStatement = "insert into login values ('"+userid+"','"+first+"','"+last+"','"+password+"')";
			int result = stat.executeUpdate(sqlStatement);
			if(result > 0){
				conn.close();
				return true;
			}
			else{
				conn.close();
				return false;
			}
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Error : "+ex.getMessage());
			return false;
		}
		
	}
		
	
	
	
}
