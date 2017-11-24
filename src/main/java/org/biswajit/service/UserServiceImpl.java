package org.biswajit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.biswajit.data.entities.User;
import org.biswajit.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public List<User> getUserList() {
		return repo.getListUser();
	}

	@Override
	public void saveOrUpdateUser(User user) {
		repo.saveOrUpdateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		repo.deleteUser(id);
	}

	@Override
	public User getUserById(int id) {
		return repo.getUserbyId(id);
	}

}
