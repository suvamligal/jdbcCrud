package com.jdbc.utils;

public interface SQLQuerry {
	String INSERT_INTO_CUSTOMER = "insert into customers_tb(userid, name, email, dob, mobile, salary,ssn, createdate, updatedate) values(?,?,?,?,?,?,?,?,?)";
	
	String SELECT_ALL_CUSTOMER = "select pid,userid, name, email, dob, mobile, salary,ssn, createdate, updatedate from customers_tb";
	
	String SELECT_PERSON_BY_ID = "select pid,userid, name, email, dob, mobile, salary,ssn, createdate, updatedate from customers_tb where pid = ?";
	
	String SELECT_PERSON_BY_USERID = "select pid,userid, name, email, dob, mobile, salary,ssn, createdate, updatedate from customers_tb where userid = ?";
	
	String DELETE_PERSON_BY_ID = "delete from customers_tb where pid = ?";
	
	String UPDATE_PERSON = "update customers_tb set name =?, email =?, dob =?, mobile =?, salary =?, ssn =?, updatedate = ? where userid = ? ";


}
