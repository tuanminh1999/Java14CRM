package cybersoft.javabackend.java14.crm.service;

import java.util.List;

import cybersoft.javabackend.java14.crm.entity.User;
import cybersoft.javabackend.java14.crm.repository.UserRepository;

public class UserService {
	private UserRepository repository;
	
	public UserService() {
		repository = new UserRepository();
	}
	
	public List<User> getUser() {
		return repository.getUser();
	}
	
	public boolean addUser(User user) {
		return repository.addUser(user) == 1 ? true : false;
	}
}
