package com.aeon.project.controllers;

import com.aeon.project.commons.*;
import com.aeon.project.entities.*;
import com.aeon.project.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userService.createUser(user);
		
	}

	@Autowired
	private TokenService tokenService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		UserPrincipal userPrincipal = userService.findByUsername(user.getUsername());
		if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
		}
		Token token = new Token();
		token.setToken(jwtUtil.genreteToken(userPrincipal));
		token.setTokenExpDate(jwtUtil.generateExpirationDate());
		token.setCreatedBy(userPrincipal.getUserId());
		tokenService.createToken(token);
		return ResponseEntity.ok(token.getToken());
	}
	
}
