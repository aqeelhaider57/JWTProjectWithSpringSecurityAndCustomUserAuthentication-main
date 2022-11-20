package com.controller;

import java.util.List;

import com.security.ProjectSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.model.Address;
import com.model.UserDetail;
import com.service.AddressService;
import com.service.UserService;

@RestController
@RequestMapping("/test")
public class HomeController {

	@Autowired
	UserService userService;

	@Autowired
	AddressService addressService;

	@PostMapping(value = { "/home" })
	public List<UserDetail> index() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = { "/index" })
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "welcome to the home page one");
		return mv;
	}

	@RequestMapping(value = { "/login" })
	public List<Address> loginPage() {
		return addressService.getAllAddresses();
	}

	@PostMapping(value = "/registeration")
	public ModelAndView registeration(@RequestParam("username") String username, @RequestParam("password") String password){

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		UserDetail userDetail = new UserDetail();
		userDetail.setUserid(username);
		userDetail.setPasswordString(bCryptPasswordEncoder.encode(password));
		userDetail.setRole("USER");

		userService.addUser(userDetail);
		return new ModelAndView("redirect:/login");
	}

}
