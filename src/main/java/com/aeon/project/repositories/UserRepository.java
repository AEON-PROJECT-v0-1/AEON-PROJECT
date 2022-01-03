package com.aeon.project.repositories;

import com.aeon.project.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
	
	  User findByUsername(String username);
}
