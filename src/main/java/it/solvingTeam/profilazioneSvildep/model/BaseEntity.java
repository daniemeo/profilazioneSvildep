package it.solvingTeam.profilazioneSvildep.model;
import java.time.LocalDateTime;


public abstract class BaseEntity {

    public abstract Long getId();

    public abstract void setId(Long id);

    @Column(name = "NUME_ID_UTENTE_INSERIMENTO")
    private Long idUtenteInserimento;

    @Column(name = "DTTM_TIMESTAMP_INSERIMENTO")
    private LocalDateTime timestampInserimento;

    @Column(name = "NUME_ID_UTENTE_AGGIORNAMENTO")
    private Long idUtenteAggiornamento;

    @Column(name = "DTTM_TIMESTAMP_AGGIORNAMENTO")
    private LocalDateTime timestampAggiornamento;

}
