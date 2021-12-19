package com.aeon.project.services.impl;

import com.aeon.project.entities.Token;
import com.aeon.project.repositories.TokenRepository;
import com.aeon.project.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl extends BaseServiceImpl implements TokenService {
	  @Autowired
	  private TokenRepository tokenRepository;
	  
	  public Token createToken(Token token){
	        return tokenRepository.saveAndFlush(token);
	  }
}
