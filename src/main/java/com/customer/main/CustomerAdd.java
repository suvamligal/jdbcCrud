package com.customer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CustomerAdd {

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
			
			//Taking input from the user.
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter the name:");
			String name = scanner.nextLine();
			
			System.out.println("Enter the email:");
			String email = scanner.nextLine();
				
			System.out.println("Enter the age:");
			int age = scanner.nextInt();
			scanner.nextLine();
					
			System.out.println("Enter the address:");
			String address = scanner.nextLine();
			
			scanner.close();
			
			//SQL querry 
			String sql = "insert into profile_tb(name,email,age,address) values(?,?,?,?)";
			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			
			//setting values inside the compiled query
			pstmt.setString(1,name);
			pstmt.setString(2,email);
			pstmt.setInt(3,age);
			pstmt.setString(4,address);
		
			//fire the querry
			int rows = pstmt.executeUpdate();
			System.out.println(rows + " number of rows inserted.");
						
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
