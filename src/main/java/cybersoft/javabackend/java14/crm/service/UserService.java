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
	
	public boolean insertUser(User user) {
		return userRepository.insertUser(user) == 1 ? true : false;
	}
	
	public User findOneByUserId(int id) {
		return userRepository.findOneByUserId(id);
	}
	
	public User updateUser(User user) {
		return userRepository.updateUser(user) == 1 ? findOneByUserId(user.getId()) : null;
	}
	
	public boolean deleteUser(int id) {
		return userRepository.deleteUser(id) == 1 ? true : false;
	}
	
}
