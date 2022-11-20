package com.service;

import java.util.ArrayList;
import java.util.List;

import com.security.ProjectSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.UserDetail;
import com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectSecurity projectSecurity;

	public UserDetail getUser(String username) {


		UserDetail userDetail = userRepository.getUser(username);
		return userDetail;

	}

	public List<UserDetail> getAllUsers() {
		List<UserDetail> userDetail = new ArrayList<>();
		userRepository.findAll().forEach(x -> userDetail.add(x));
		return userDetail;
	}

	public boolean addUser(UserDetail userDetail) {
		if (userDetail.equals(null)) {
			return false;
		} else {
			userRepository.save(userDetail);
			return true;
		}

	}

	public boolean deleteUser(UserDetail userDetail) {
		if (userDetail.equals(null)) {
			return false;
		} else {
			userRepository.delete(userDetail);
			return true;
		}
	}

	public UserDetail getSingleUser(long id) {
		UserDetail userDetail = userRepository.getOne(id);
		return userDetail;
	}
}
