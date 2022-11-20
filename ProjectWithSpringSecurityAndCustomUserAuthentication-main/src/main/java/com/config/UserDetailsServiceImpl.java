package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.model.UserDetail;
import com.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail userDetail = userService.getUser(username);
		if (userDetail == null) {
			throw new UsernameNotFoundException("Not found any user!");
		}

		CustomeUserDetails customeUserDetails = new CustomeUserDetails(userDetail);
		return customeUserDetails;
	}

}
