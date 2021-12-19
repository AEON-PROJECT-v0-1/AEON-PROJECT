package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  User findByUsername(String username);
}