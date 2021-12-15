package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{
	Token findByToken(String Token);
}
