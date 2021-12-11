package Security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nimbusds.jwt.JWTClaimsSet;
@Component

public class JwtUtil {
	private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);
	
	private static final String USER ="user";
	
	private static final String Secret ="dayladoancodebimat";
	
	public String genreteToken(UserPrincipal user) {
		String token = null;
		try {
			JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
			builder.claim(USER, user);
			builder.expirationTime(generateExpirationDate());
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return token;
		
	}
	public Date generateExpirationDate() {
		return new Date(System.currentTimeMillis()+864000000);		
	}
}
