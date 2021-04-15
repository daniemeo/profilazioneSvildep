package it.solvingTeam.profilazioneSvildep.configuration;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import it.solvingTeam.profilazioneSvildep.model.UserPrincipal;

@RequiredArgsConstructor
@Component
public class JwtTokenUtil implements Serializable {


	@Value("${jwt.secret}")
	private String secret;
	//va a riprendersi la secret presente nelle properties

	public String getCfFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

//	public Date getIssuedAtDateFromToken(String token) {
//		return getClaimFromToken(token, Claims::getIssuedAt);
//	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

//	private Boolean ignoreTokenExpiration(String token) {
//		// here you specify tokens, for that the expiration is ignored
//		return false;
//	}


//	public Boolean canTokenBeRefreshed(String token) {
//		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
//	}

	public Boolean validateToken(String codiceFiscale, UserPrincipal user) {
		return (codiceFiscale.equals(user.getUser().getCodiceFiscale()));
	}
}
