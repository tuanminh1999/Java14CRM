package cybersoft.javabackend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.javabackend.java14.crm.datasource.MySQLConnection;
import cybersoft.javabackend.java14.crm.model.User;

public class UserRepository {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;
	
	public List<User> getUser() {
		List<User> users = new LinkedList<User>();
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT id, email, password, fullname, avatar, role_id FROM users";

			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassWord(rs.getString("password"));
				user.setFullName(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setRole_id(rs.getInt("role_id"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return users;
	}
	
	public int addUser(User user) {
		try {
			connection = MySQLConnection.getConnection();
			String query = "INSERT INTO user(email,password,fullname,avatar,role_id) VALUE (?,?,?,?,?,?)";
				
			statement = connection.prepareStatement(query);
			
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassWord());
			statement.setString(3, user.getFullName());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, user.getRole_id());
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
		
	}
}
