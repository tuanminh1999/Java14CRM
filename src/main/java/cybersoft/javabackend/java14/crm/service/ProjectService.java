package cybersoft.javabackend.java14.crm.service;

import java.util.List;

import cybersoft.javabackend.java14.crm.entity.Project;
import cybersoft.javabackend.java14.crm.repository.ProjectRepository;

public class ProjectService {
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		projectRepository = new ProjectRepository();
	}
	
	public List<Project> getProject() {
		return projectRepository.getProject();
	}
	
	public boolean insertProject(Project project) {
		return projectRepository.insertProject(project) == 1 ? true : false;
	}
	
	public Project findOneByProjectId(int id) {
		return projectRepository.findOneByProjectId(id);
	}
	
	public Project updateProject(Project project) {
		project.setCreateBy(project.getUser().getRoleId());
		return projectRepository.updateProject(project) == 1 ? findOneByProjectId(project.getId()) : null;
	}
	
	public boolean deleteProject(int id) {
		return projectRepository.deleteProject(id) == 1 ? true : false;
	}
	
}
