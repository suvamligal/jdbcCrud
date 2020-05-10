package com.jdbc.main;

import java.util.Date;
import java.util.Scanner;

import com.jdbc.dao.PersonDao;
import com.jdbc.dao.PersonDaoImpl;
import com.jdbc.dao.entity.PersonEntity;
import com.jdbc.utils.DateUtils;

public class InsertPersonMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		PersonDao personDao = new PersonDaoImpl();
		
		System.out.println("Enter the userid:");
		String userid = scanner.next();
		
		System.out.println("Enter the name:");
		String name = scanner.next();
		
		System.out.println("Enter the email:");
		String email = scanner.next();
		
		System.out.println("Enter the date of birth:");
		String date = scanner.next();
		Date dob = DateUtils.dateFromString(date);    // 12-03-2020
		
		System.out.println("Enter the mobile number:");
		long mobile = scanner.nextLong();
		
		System.out.println("Enter the salary:");
		Double salary = scanner.nextDouble();
		
		System.out.println("Enter the SSN:");
		int ssn = scanner.nextInt();
		
		
		PersonEntity entity = new PersonEntity(0, userid, name, email, dob, mobile, salary, ssn, null, null);
		System.out.println("Saving it...............");
		
		personDao.Save(entity);
		
		System.out.println("Showing data.......");
		personDao.findAll().forEach(System.out::println);
		
		scanner.close();
	}

}
