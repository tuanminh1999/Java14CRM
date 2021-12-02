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
	
	public Task findOneByTaskId(int id) {
		return taskRepository.findOneByTaskId(id);
	}
	
	public boolean insertTask(Task task) {
		return taskRepository.insertTask(task) == 1 ? true : false;
	}
	
	public Task updateTask(Task task) {
		return taskRepository.updateTask(task) == 1 ? findOneByTaskId(task.getId()) : null;
	}
	
	public boolean deleteTask(int id) {
		return taskRepository.deleteTask(id) == 1 ? true : false;
	}
}
