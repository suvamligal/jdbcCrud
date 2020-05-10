package com.customer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoadCustomers {

	public static void main(String[] args) {
		
		//JDBC Programming
		try {
			
			//loading the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//making connection to the driver
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person_db","root","Palpa075#");
			if(conn!= null) {
				System.out.println("Connection Successful!");
			}
			
			//SQL querry 
			String sql = "select name,email,age,address from profile_tb";
			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			
			//fire the querry
			ResultSet resultSet = pstmt.executeQuery();
			List<Customer> customers = new ArrayList<>();
			
			while(resultSet.next()) {
				String name = resultSet.getString(1);
				String email = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String address = resultSet.getString(4);  
				
				Customer customer = new Customer(name, email, age, address);
				customers.add(customer);
				
			}
			
			//printing all the customers from the list
			customers.forEach(System.out::println);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
