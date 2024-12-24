package com.online.banking.dao;

import java.sql.*;
import java.util.Properties;
import java.io.*;

//singletone class.
public class DbConfig {

	protected static Connection connection;
	protected static PreparedStatement preparedStatement;
	protected static ResultSet resultSet;

	private static DbConfig dbConfig = null;

	private DbConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			File file = new File("");
			String path = file.getAbsolutePath();
			FileInputStream fileInputStream = new FileInputStream(path + "\\src\\main\\resources\\dbconfig.properties");
			Properties p = new Properties();
			p.load(fileInputStream);
//			String driverClassName = p.getProperty("driver");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String url = p.getProperty("url");

			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println("Error is " + e);
		}
	}

	public static DbConfig getInstance() {
		if (dbConfig == null) {
			dbConfig = new DbConfig();
		}
		return dbConfig;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static PreparedStatement getPreStatement() {
		return preparedStatement;
	}

	public static ResultSet getResult() {
		return resultSet;
	}

}
