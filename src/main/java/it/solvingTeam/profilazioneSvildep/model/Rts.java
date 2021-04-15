package it.solvingTeam.profilazioneSvildep.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter
@Setter
@Entity
@Table(name = "D_RTS")
public class Rts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "PK_SEQU_ID_RTS")
	private long id;
	@Column(name = "DESC_DENOMINAZIONE_RTS")
	private String denominazioneRTS;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK1_COMUNI_RTS")
	private Comune comune;
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "FK1_RECAPITI_RTS")
	private Recapito recapito;

}
	
	

}
