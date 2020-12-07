package thuy.practicejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public User checkLogin(String email, String password) throws SQLException, 
			ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/session";
		String dbUser = "root";
		String dbPassword = "password";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM users WHERE email = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		User user = null;

		if (result.next()) {
			user = new User();
			user.setFullname(result.getString("fullname"));
			user.setEmail(email);
		}

		connection.close();

		return user;
	}
}


/*
CREATE DATABASE SESSION;
 
CREATE TABLE USERS (
 	id INT(11) NOT NULL AUTO_INCREMENT,
 	email VARCHAR(45) NOT NULL,
 	password VARCHAR(45) NOT NULL,
 	fullname VARCHAR(45) NOT NULL,
 	PRIMARY KEY (id));
 	
INSERT INTO USERS VALUES (1, 'admin1@gmail.com', 'pass123', 'Admin One');
INSERT INTO USERS VALUES (2, 'admin2@gmail.com', 'pass456', 'Admin Two');
 
 
 */

