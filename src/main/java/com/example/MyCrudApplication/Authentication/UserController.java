package com.example.MyCrudApplication.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/signUp")
	public String addUser(@RequestBody User user) {
	User gottenUser = new User(user.getUserName(),passwordEncoder.encode(user.getPassword()),user.getFirstName(),user.getLastName(),user.getEmail());
	userRepository.save(gottenUser);
	return "User " + user.getUserName() + " is Saved !";
	}
}
