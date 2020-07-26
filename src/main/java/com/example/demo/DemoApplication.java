package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/Mysql?autoReconnect=true&useSSL=false&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
		String user = "root";
		String password = "test";
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt = myConn.createStatement();
			String sql = "select * from sakila.actor";
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()){
				System.out.println(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
