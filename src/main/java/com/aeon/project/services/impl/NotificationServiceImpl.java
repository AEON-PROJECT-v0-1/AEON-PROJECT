package com.aeon.project.services.impl;

import com.aeon.project.commons.NotificationPrincipal;
import com.aeon.project.commons.PostPrincipal;
import com.aeon.project.entities.Notification;
import com.aeon.project.entities.Post;
import com.aeon.project.repositories.NotificationRepository;
import com.aeon.project.services.NotificationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Override
	public Notification createNotifcation(Notification notification) {
		return notificationRepository.saveAndFlush(notification);
	}
	
//	@Override
//	public List<Notification> GetAllNotification() {
//		return notificationRepository.findAll();
//	} Khong dung get all khi goi data , vi khi data goi len so luong qua lon lam chet data
	
	@Override
	public NotificationPrincipal findNotification(String custNo) {	
		List<Notification> listNoti = notificationRepository.findByCustNo(custNo);
		NotificationPrincipal notificationPrincipal = new NotificationPrincipal();
		for(int i=0 ; i < listNoti.size() ; i++) {
			Notification notification = listNoti.get(i);
			notificationPrincipal.setCustNo(notification.getCustNo());
			notificationPrincipal.setNotificationName(notification.getNotificationName());
			notificationPrincipal.setNotificationNo(notification.getNotificationNo());
			notificationPrincipal.setNotificationNote(notification.getNotificationNote());
			notificationPrincipal.setSeenYn(notification.getSeenYn());
		}
		return notificationPrincipal;
	}
	@Override
	public Notification UpdateNotificationId(Notification notification) {
		return notificationRepository.save(notification);
	}
	
	
}
