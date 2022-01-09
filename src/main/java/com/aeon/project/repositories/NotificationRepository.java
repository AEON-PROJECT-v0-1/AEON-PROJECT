package com.aeon.project.repositories;

import com.aeon.project.entities.Notification;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends BaseRepository<Notification, Long> {
//	Notification findByCustNo(String custNo);
	List<Notification> findByCustNo(String custNo);
}
