package com.aeon.project.controllers;

import com.aeon.project.commons.NotificationPrincipal;
import com.aeon.project.commons.PostPrincipal;
import com.aeon.project.entities.*;
import com.aeon.project.services.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
//	@GetMapping("/GetAllPost")
//	public List<Post> GetPost() {
//		List<Post> post = notificationService.GetAllPost();
//        return post;
//	} Khong dung get all data trong he thong vi neu so luong lon se lam down he he thong
	
	@PostMapping("/notifiMessage")
	public ResponseEntity<?> login(@RequestBody Notification notification) {
		NotificationPrincipal notifiMessage = notificationService.findNotification(notification.getCustNo());
		return ResponseEntity.ok(notifiMessage);
	}
	@PostMapping("/insert")
	public ResponseEntity<?> Insert(@RequestBody Notification notification) {
		notificationService.createNotifcation(notification);
        return new ResponseEntity<>("Insert Post successfully", HttpStatus.OK);
		
	}
//	
//	@PutMapping("/UpdatePostById")
//	public ResponseEntity<?> Update(Iterable<Long> id) {
//		notificationService.UpdatePostById(id);
//        return new ResponseEntity<>("Insert Post successfully", HttpStatus.OK);
//		
//	}
	
}
