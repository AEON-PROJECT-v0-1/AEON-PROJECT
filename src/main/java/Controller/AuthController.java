package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Token;
import Entity.User;
import Security.JwtUtil;
import Security.UserPrincipal;
import Service.TokenService;
import Service.UserService;

@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userService.createUser(user);

	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		UserPrincipal userPrincipal = userService.findByUsername(user.getUsername());
		if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
		}
		Token token = new Token();
		token.setToken(jwtUtil.generateToken(userPrincipal));
		token.setTokenExpDate(jwtUtil.generateExpirationDate());
		token.setCreatedBy(userPrincipal.getUserId());
		tokenService.createToken(token);
		return ResponseEntity.ok(token.getToken());
	}
}
