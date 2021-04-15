package it.solvingTeam.profilazioneSvildep.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.solvingTeam.profilazioneSvildep.model.Rts;
import it.solvingTeam.profilazioneSvildep.model.Utente;
import it.solvingTeam.profilazioneSvildep.model.UserPrincipal;
import it.solvingTeam.profilazioneSvildep.repository.RtsRepository;
import it.solvingTeam.profilazioneSvildep.repository.UtenteRepository;

@Service
@Getter
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

	private final UtenteRepository userRepository;

	private final RtsRepository rtsRepository;

	@Override
	public UserDetails loadUserByUsername(String codiceFiscale) throws UsernameNotFoundException {
		Utente utente = userRepository.findByCodiceFiscale(codiceFiscale);
		Rts rts = userRepository.findByIdEagerRts(utente.getId()).orElse(null).getRts();


		return new UserPrincipal(utente, rts);
	}
}