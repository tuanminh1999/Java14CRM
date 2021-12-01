package cybersoft.javabackend.java14.crm.service;

import java.util.List;

import cybersoft.javabackend.java14.crm.entity.Task;
import cybersoft.javabackend.java14.crm.repository.TaskRepository;

public class TaskService {
	private TaskRepository taskRepository;
	
	public TaskService() {
		taskRepository = new TaskRepository();
	}
	
	public List<Task> getTask() {
		return taskRepository.getTask();
	}
}
