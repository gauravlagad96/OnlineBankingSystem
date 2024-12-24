package com.online.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbState {

	DbConfig config = DbConfig.getInstance();

	protected Statement statement;
	protected Connection connection = config.getConnection();
	protected PreparedStatement preStmt = config.getPreStatement();
	protected ResultSet resultSet = config.getResult();
	
	

}
