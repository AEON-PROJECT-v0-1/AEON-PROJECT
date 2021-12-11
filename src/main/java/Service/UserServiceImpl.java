package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.User;
import Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	   @Autowired
	    private UserRepository userRepository;

	    @Override
	    public User createUser(User user) {
	        return userRepository.saveAndFlush(user);
	    }

}
