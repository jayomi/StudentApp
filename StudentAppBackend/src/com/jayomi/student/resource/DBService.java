package com.jayomi.student.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.functors.ForClosure;

@Path("/DBService")
public class DBService {

	
	public Connection setConnection() {

		
		final String dburl = "jdbc:mysql://localhost:3306/studentdb";
		String dbname="studentdb";
		final String user = "root";
		final String password = "root";
		Connection conn = null;
		Statement stmt = null;
		
		try{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(dburl, user, password);
				
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	
	}
	
	
	
}
