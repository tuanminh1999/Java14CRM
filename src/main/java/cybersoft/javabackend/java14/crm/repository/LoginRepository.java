package cybersoft.javabackend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cybersoft.javabackend.java14.crm.db.MySQLConnection;
import cybersoft.javabackend.java14.crm.entity.Login;
import cybersoft.javabackend.java14.crm.entity.Role;
import cybersoft.javabackend.java14.crm.entity.User;

public class LoginRepository {

	public Login checkLogIn(String email, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT email, password FROM crm.crm_user WHERE username= '"?"' and password= '"?"' ";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			rs = statement.executeQuery();

			while (rs.next()) {
				Login l = new Login(rs.getString(1), rs.getString(2));
				return l;
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Lỗi đóng kết nối");
				e.printStackTrace();
			}
		}
		return null;
	}

}
