package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdbc.dao.entity.PersonEntity;
import com.jdbc.utils.SQLConnection;
import com.jdbc.utils.SQLQuerry;

public class PersonDaoImpl implements PersonDao{
	
	@Override
	public String updatePerson(PersonEntity entity) {
		
		int rowcount = 0;
		
		try (Connection conn = SQLConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQLQuerry.UPDATE_PERSON);)
		{
			PersonEntity dbpersonEntity = findByUserid(entity.getUserid());
			
			boolean status = false;
					
			if (entity.getUserid() != null) {
				dbpersonEntity.setUserid(entity.getUserid());
			}else {
				return "user id not present!";
			}

			if (entity.getDob() != null) {
				dbpersonEntity.setDob(entity.getDob());
				 status=true;
			}
			if (entity.getEmail() != null) {
				dbpersonEntity.setEmail(entity.getEmail());
				status=true;
			}
			if (entity.getMobile() != 0) {
				dbpersonEntity.setMobile(entity.getMobile());
				status=true;
			}
			if (entity.getName() != null) {
				dbpersonEntity.setName(entity.getName());
				status=true;
			}

			if (entity.getSalary() != 0) {
				dbpersonEntity.setSalary(entity.getSalary());
				status=true;
			}
			
			if (entity.getSsn() != 0) {
				dbpersonEntity.setSsn(entity.getSsn());
				status=true;
			}
			
			if (entity.getUpdatedate() != null) {
				status=true;
				dbpersonEntity.setUpdatedate(entity.getUpdatedate());
			}

			
			if(status) {
				pstmt.setString(1, dbpersonEntity.getName());
				pstmt.setString(2, dbpersonEntity.getEmail());
				pstmt.setDate(3, new java.sql.Date(entity.getDob().getTime()));
				pstmt.setLong(4, dbpersonEntity.getMobile());
				pstmt.setDouble(5, dbpersonEntity.getSalary());
				pstmt.setInt(6, dbpersonEntity.getSsn());
				pstmt.setTimestamp(7, new Timestamp(new Date().getTime()));
				pstmt.setString(8, dbpersonEntity.getUserid());
				rowcount = pstmt.executeUpdate();
		}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return rowcount > 0 ? "Success" : "no rows affected";
	}
	

	/**
	 * This method inserts the value in the database.
	 * 
	 * @param entity object of PersonEntity passed. 
	 * 
	 */
	
	@Override
	public String Save(PersonEntity entity) {

		int rowcount = 0;
		try (Connection conn = SQLConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQLQuerry.INSERT_INTO_CUSTOMER);)
		{
			

			pstmt.setString(1, entity.getUserid());
			pstmt.setString(2, entity.getName());
			pstmt.setString(3, entity.getEmail());

			//converison of util package date to sql package date.

			pstmt.setDate(4, new java.sql.Date(entity.getDob().getTime()));	
			pstmt.setLong(5,entity.getMobile());
			pstmt.setDouble(6, entity.getSalary());
			pstmt.setInt(7, entity.getSsn());

			pstmt.setTimestamp(8, new Timestamp(new Date().getTime()));
			pstmt.setTimestamp(9, new Timestamp(new Date().getTime()));

			rowcount = pstmt.executeUpdate();					

		} catch (Exception e) {
			e.printStackTrace();
		}	
		return rowcount>0?"Success":"no rows updated";	
	}
	
	

	@Override
	public List<PersonEntity> findAll(){

		List<PersonEntity> personEntities = new ArrayList<>();

		try {
			Connection conn = SQLConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQLQuerry.SELECT_ALL_CUSTOMER);	

			ResultSet resultset = pstmt.executeQuery();

			while(resultset.next()) {
				PersonEntity personEntity = new PersonEntity(
						resultset.getInt(1), 
						resultset.getString(2),
						resultset.getString(3),
						resultset.getString(4),
						resultset.getDate(5),
						resultset.getLong(6),
						resultset.getDouble(7),
						resultset.getInt(8),
						resultset.getTimestamp(9),
						resultset.getTimestamp(10)
						);
				personEntities.add(personEntity);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}	

		return personEntities;

	}


	@Override
	public PersonEntity findById(int pid){

		PersonEntity personEntity = null;

		try (Connection conn = SQLConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuerry.SELECT_PERSON_BY_ID))
		{
			pstmt.setInt(1, pid);

			ResultSet resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				personEntity = new PersonEntity(
						resultSet.getInt(1), 
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDate(5),
						resultSet.getLong(6),
						resultSet.getDouble(7),
						resultSet.getInt(8),
						resultSet.getTimestamp(9),
						resultSet.getTimestamp(10)
						);
			}	

		} 
		catch (Exception e) {
			e.printStackTrace();

		}
		return personEntity;	
	}
	
	
	
	
	@Override
	public PersonEntity findByUserid(String userid){

		PersonEntity personEntity = null;

		try (Connection conn = SQLConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuerry.SELECT_PERSON_BY_USERID))
		{
			pstmt.setString(1, userid);

			ResultSet resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				personEntity = new PersonEntity(
						resultSet.getInt(1), 
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDate(5),
						resultSet.getLong(6),
						resultSet.getDouble(7),
						resultSet.getInt(8),
						resultSet.getTimestamp(9),
						resultSet.getTimestamp(10)
						);
			}	

		} 
		catch (Exception e) {
			e.printStackTrace();

		}
		return personEntity;	

	}


	@Override
	public int deleteById(int pid){

		int rowcount = 0;

		try (Connection conn = SQLConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuerry.DELETE_PERSON_BY_ID))

		{

			pstmt.setInt(1, pid);

			rowcount = pstmt.executeUpdate();	

		} 
		catch (Exception e) {
			e.printStackTrace();

		}
		return rowcount;

	}

	

}
