package org.biswajit.service;

import java.util.List;

import org.biswajit.data.entities.User;

public interface UserService {
 
	public List<User> getUserList();
	
	public void saveOrUpdateUser(User user);
	
	public void deleteUser(int id);
	
	public User getUserById(int id);
}
