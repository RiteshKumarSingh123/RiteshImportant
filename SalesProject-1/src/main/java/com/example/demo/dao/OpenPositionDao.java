package com.example.demo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import org.hibernate.Session;
import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OpenPositionDao {

	@Autowired
	private EntityManager entityManager;
	

	
	
	public Users getUserData(AuthRequest request) {
		Users user = new Users();
		entityManager.unwrap(Session.class).doWork(connection->{
			try(CallableStatement cstmt = connection.prepareCall("{ call userDetailsData(?, ?) }")) {

				cstmt.setString(1, request.getUserName());
				System.out.println(request.getUserName());
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				cstmt.execute();
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				while(rs.next()) {
					user.setCatererId(rs.getString("catererId"));
					System.out.println(rs.getString("catererId")); 
					user.setPassword(rs.getString("password")); 
					System.out.println(rs.getString("password"));
					user.setUsername(rs.getString("name"));
					System.out.println(rs.getString("name"));  
				}
			}
		});
		return user;
	}

	
	}
