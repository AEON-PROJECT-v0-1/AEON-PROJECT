package Service;

import Entity.User;
import Security.UserPrincipal;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);

}
