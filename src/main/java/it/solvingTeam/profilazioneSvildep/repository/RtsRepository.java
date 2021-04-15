package it.solvingTeam.profilazioneSvildep.repository;

import java.util.Optional;

import it.solvingTeam.profilazioneSvildep.model.Rts;
import it.solvingTeam.profilazioneSvildep.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RtsRepository extends JpaRepository<Rts,Long> {
	public Optional<Rts> findRtsByUser_id(Long id);


}
