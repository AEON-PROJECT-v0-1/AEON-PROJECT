package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Token;
import Repository.TokenRepository;

@Service
public class TokenServiceImpl implements TokenService {
	  @Autowired
	  private TokenRepository tokenRepository;
	  
	  public Token createToken(Token token){
	        return tokenRepository.saveAndFlush(token);
	  }
}
