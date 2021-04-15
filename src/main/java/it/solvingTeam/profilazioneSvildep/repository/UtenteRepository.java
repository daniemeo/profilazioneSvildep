package it.solvingTeam.profilazioneSvildep.repository;

import java.util.Optional;

import it.solvingTeam.profilazioneSvildep.model.Rts;
import it.solvingTeam.profilazioneSvildep.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UtenteRepository extends JpaRepository<Utente,Long> {

	public Utente findByCodiceFiscale(String codiceFiscale);

	@Query("from Utente u join fetch u.rts where u.id = ?1")
	public Optional<Utente> findByIdEagerRts(Long id);
}
