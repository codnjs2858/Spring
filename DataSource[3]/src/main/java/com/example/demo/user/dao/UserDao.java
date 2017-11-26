package com.example.demo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


public class UserDao {
	
	@Autowired
	DataSource dataSource;
	
	public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException { // 2
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = dataSource.getConnection();
			ps = stmt.makePreparedStatement(c);

		} catch (SQLException e) {
		    throw e;
		} finally {
		    if(ps != null){try{ps.close();}catch(SQLException e){}}
		    if(c != null){try{c.close();}catch(SQLException e){}}
		}
	}
	
	public void deleteAll() throws SQLException{

		StatementStrategy st = new DeleteAllStatement();
		jdbcContextWithStatementStrategy(st);
	}
	
	
	public void add(){
		System.out.println("zxcv");
	}

	
	
	
	
	
	public void get(){
		System.out.println("asdf");
	}
	
	public void getCount() throws SQLException{
		System.out.println("select count(*) from users");
	}

}
