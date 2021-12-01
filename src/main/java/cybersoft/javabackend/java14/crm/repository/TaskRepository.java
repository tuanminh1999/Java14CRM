package cybersoft.javabackend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.javabackend.java14.crm.db.MySQLConnection;
import cybersoft.javabackend.java14.crm.entity.Project;
import cybersoft.javabackend.java14.crm.entity.Status;
import cybersoft.javabackend.java14.crm.entity.Task;

public class TaskRepository {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public List<Task> getTask() {
		List<Task> tasks = new LinkedList<Task>();
		try {
			connection = MySQLConnection.getConnection();
			StringBuilder query = new StringBuilder("SELECT t.id, t.assignee, t.description, t.start_date, t.end_date, t.name, t.project_id, ");
			query.append("t.status_id ,s.name, s.description, p.name, p.description, p.start_date, p.end_date, create_by ");
			query.append("FROM crm_task AS t INNER JOIN crm_status AS s ON t.status_id = s.id ");
			query.append("INNER JOIN crm_project AS p ON t.project_id = p.id ORDER BY t.project_id");

			statement = connection.prepareStatement(query.toString());
			rs = statement.executeQuery();

			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("t.id"));
				task.setAssignee(rs.getInt("t.assignee"));
				task.setDescription(rs.getString("t.description"));
				task.setStartDate(rs.getDate("t.start_date"));
				task.setEndDate(rs.getDate("t.end_date"));
				task.setName(rs.getString("t.name"));
				task.setStatusId(rs.getInt("t.status_id"));
				
				Status status = new Status();
				status.setName(rs.getString("s.name"));
				status.setDescription(rs.getString("s.description"));
				task.setStatus(status);
				
				Project project = new Project();
				project.setName(rs.getString("p.name"));
				project.setDescription(rs.getString("p.description"));
				project.setStartDate(rs.getDate("p.start_date"));
				project.setEndDate(rs.getDate("p.end_date"));
				project.setCreateBy(rs.getInt("p.create_by"));
				task.setProject(project);
				
				tasks.add(task);
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
		return tasks;
	}
}
