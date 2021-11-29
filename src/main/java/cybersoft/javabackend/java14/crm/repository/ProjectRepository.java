package cybersoft.javabackend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.javabackend.java14.crm.db.MySQLConnection;
import cybersoft.javabackend.java14.crm.entity.Project;
import cybersoft.javabackend.java14.crm.entity.User;

public class ProjectRepository {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public List<Project> getProject() {
		List<Project> projects = new LinkedList<Project>();
		try {
			connection = MySQLConnection.getConnection();
			StringBuilder query = new StringBuilder("SELECT p.id, p.name, p.description, p.start_date, p.end_date, p.create_by, u.id, ");
			query.append("u.name, u.email, u.password, u.phone, u.address, u.role_id FROM crm_project AS p INNER JOIN crm_user AS u ");
			query.append("ON p.create_by = u.id ORDER BY p.id ASC");
			
			statement = connection.prepareStatement(query.toString());
			rs = statement.executeQuery();

			while (rs.next()) {
				Project project = new Project();
				project.setId(rs.getInt("p.id"));
				project.setName(rs.getString("p.name"));
				project.setDescription(rs.getString("p.description"));
				project.setStartDate(rs.getDate("p.start_date"));
				project.setEndDate(rs.getDate("p.end_date"));
				project.setCreateBy(rs.getInt("p.create_by"));
				
				User user = new User();
				user.setId(rs.getInt("u.id"));
				user.setName(rs.getString("u.name"));
				user.setEmail(rs.getString("u.email"));
				user.setPassword(rs.getString("u.password"));
				user.setPhone(rs.getString("u.phone"));
				user.setAddress(rs.getString("u.address"));
				project.setUser(user);
				
				projects.add(project);
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
		return projects;
	}
	
	public Project findOneByProjectId(int id) {
		try {
			connection = MySQLConnection.getConnection();
			StringBuilder query = new StringBuilder("SELECT p.id, p.name, p.description, p.start_date, p.end_date, p.create_by, u.id, ");
			query.append("u.name, u.email, u.password, u.phone, u.address, u.role_id FROM crm_project AS p INNER JOIN crm_user AS u ");
			query.append("ON p.create_by = u.id WHERE p.id = ?");

			statement = connection.prepareStatement(query.toString());
			statement.setInt(1, id);
			rs = statement.executeQuery();

			while (rs.next()) {
				Project project = new Project();
				project.setId(rs.getInt("p.id"));
				project.setName(rs.getString("p.name"));
				project.setDescription(rs.getString("p.description"));
				project.setStartDate(rs.getDate("p.start_date"));
				project.setEndDate(rs.getDate("p.end_date"));
				project.setCreateBy(rs.getInt("p.create_by"));
				
				User user = new User();
				user.setId(rs.getInt("u.id"));
				user.setName(rs.getString("u.name"));
				user.setEmail(rs.getString("u.email"));
				user.setPassword(rs.getString("u.password"));
				user.setPhone(rs.getString("u.phone"));
				user.setAddress(rs.getString("u.address"));
				project.setUser(user);
				
				return project;
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
	
	public int deleteByCreateBy(int createBy) {
		try {
			connection = MySQLConnection.getConnection();
			String query = "DELETE FROM crm_project WHERE create_by = ?";

			statement = connection.prepareStatement(query);

			statement.setInt(1, createBy);

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Lỗi đóng kết nối");
				e.printStackTrace();
			}
		}
		return 0;

	}

	public int insertProject(Project project) {
		try {
			connection = MySQLConnection.getConnection();
			String query = "INSERT INTO crm_project(name, description, start_date, end_date, create_by) VALUES (?,?,?,?,?)";

			statement = connection.prepareStatement(query);

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, project.getStartDate());
			statement.setDate(4, project.getEndDate());
			statement.setInt(5, project.getCreateBy());

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Lỗi đóng kết nối");
				e.printStackTrace();
			}
		}
		return 0;

	}
	
	public int updateProject(Project project) {
		try {
			connection = MySQLConnection.getConnection();
			String query = "UPDATE crm_project SET name = ?, description = ?, start_date = ?, end_date = ?, create_by = ? WHERE id = ?";

			statement = connection.prepareStatement(query);

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, project.getStartDate());
			statement.setDate(4, project.getEndDate());
			statement.setInt(5, project.getCreateBy());
			statement.setInt(6, project.getId());

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Lỗi đóng kết nối");
				e.printStackTrace();
			}
		}
		return 0;

	}
	
	public int deleteProject(int id) {
		try {
			connection = MySQLConnection.getConnection();
			String query = "DELETE FROM crm_project WHERE id = ?";

			statement = connection.prepareStatement(query);

			statement.setInt(1, id);

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Lỗi đóng kết nối");
				e.printStackTrace();
			}
		}
		return 0;

	}
}
