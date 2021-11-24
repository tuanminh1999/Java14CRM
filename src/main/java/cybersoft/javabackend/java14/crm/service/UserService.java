package cybersoft.javabackend.java14.crm.service;

import java.util.List;

import cybersoft.javabackend.java14.crm.entity.User;
import cybersoft.javabackend.java14.crm.repository.UserRepository;

public class UserService {
	private UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public List<User> getUser() {
		return userRepository.getUser();
	}
	
	public boolean addUser(User user) {
		return userRepository.addUser(user) == 1 ? true : false;
	}
	
}
