package com.jdbc.dao;

import java.util.List;

import com.jdbc.dao.entity.PersonEntity;

public interface PersonDao {
	
	public String Save(PersonEntity entity);
	
	public List<PersonEntity> findAll();
	
	public PersonEntity findById(int pid);

	public int deleteById(int pid);
	
	public String updatePerson(PersonEntity entity);

	public PersonEntity findByUserid(String userid);

	

}
