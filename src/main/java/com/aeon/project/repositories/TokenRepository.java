package com.aeon.project.repositories;

import com.aeon.project.entities.Token;

public interface TokenRepository extends BaseRepository<Token, Long>{
	Token findByToken(String Token);
}
