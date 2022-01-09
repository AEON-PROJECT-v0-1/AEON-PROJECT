package com.aeon.project.services;

import com.aeon.project.commons.NotificationPrincipal;
import com.aeon.project.entities.Notification;

public interface NotificationService {
	NotificationPrincipal findNotification(String custNo);
	Notification createNotifcation(Notification notification);
//	List<Notification> GetAllNotification();
	Notification UpdateNotificationId(Notification notification);
}
