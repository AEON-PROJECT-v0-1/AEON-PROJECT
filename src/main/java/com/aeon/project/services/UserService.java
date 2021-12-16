package com.aeon.project.services;

import com.aeon.project.commons.UserPrincipal;
import com.aeon.project.entities.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);

}
