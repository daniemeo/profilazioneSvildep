package it.solvingTeam.profilazioneSvildep.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1099943041288877538L;

	private final Utente user;
	private final Rts rts;

	public UserPrincipal(Utente user, Rts rts) {
		this.user = user;
		this.rts = rts;
	}

	public Utente getUser() {
		return user;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(user.getRuolo().getDescrizione()));
	}

	@Override
	public String getPassword() {
		return "";
	}

	@Override
	public String getUsername() {
		return "";
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}