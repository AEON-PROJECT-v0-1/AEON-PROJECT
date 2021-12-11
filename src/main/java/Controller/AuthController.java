package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.User;
import Service.UserService;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userservice.createUser(user);
		
	}
	
	
}
