package cybersoft.javabackend.java14.crm.service;

import cybersoft.javabackend.java14.crm.model.User;
import cybersoft.javabackend.java14.crm.repository.UserRepository;

public class UserService {
	private UserRepository repository;
	
	public UserService() {
		repository = new UserRepository();
	}
	
	public boolean addUser(User user) {
		return repository.addUser(user) == 1 ? true : false;
	}
}
