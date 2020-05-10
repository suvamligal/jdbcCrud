package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.dao.PersonDao;
import com.jdbc.dao.PersonDaoImpl;

public class DeletePersonMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		PersonDao personDao = new PersonDaoImpl();
		
		System.out.println("Enter the person primary id to be deleted: ");
		int pid = scanner.nextInt();
		
		personDao.deleteById(pid);
		
		System.out.println("Record with primary id " + pid + " is deleted.");
		personDao.findAll().forEach(System.out::println);
		
		scanner.close();
	}

}
