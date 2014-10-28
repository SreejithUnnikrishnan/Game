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
				String sqlStatement = "select qst_no,question,option1,option2,option3,option4,answer from "+table+" where qst_id="+questionNum;
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
	
}
