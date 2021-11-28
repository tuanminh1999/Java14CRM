package cybersoft.javabackend.java14.crm.entity;

public class Task {
	private int id;
	private int assignee;
	private String name;
	private String description;
	private String start_date;
	private String end_date;
	private int status;
	private int project;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAssignee() {
		return assignee;
	}
	public void setAssignee(int assignee) {
		this.assignee = assignee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}

	
}
