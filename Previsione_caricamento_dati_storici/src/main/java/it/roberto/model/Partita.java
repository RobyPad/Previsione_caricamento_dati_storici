package it.roberto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Spring jpa jars.
@Entity
@Table(name= "partita")


public class Partita 
{
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	*/
	
	@Id
	private String id;
	@Column(name = "nazione")
	private String nazione;
	@Column(name = "tipo_competizione")
	private String tipoCompetizione;
	@Column(name = "turno_competizione")
	private String turnoCompetizione;
	@Column(name = "annata")
	private String annata;
	@Column(name = "data")
	private String data;
	@Column(name = "ora")
	private String ora;
	@Column(name = "squadra_casa")
	private String squadraCasa;
	@Column(name = "goal_casa")
	private int goalCasa;
	@Column(name = "squadra_trasferta")
	private String squadraTrasferta;
	@Column(name = "goal_trasferta")
	private int goalTrasferta;
	
	
	
	public Partita() { }
	
	public Partita(String id, String nazione, String tipoCompetizione, String turnoCompetizione,
			String annata, String data, String ora, String squadraCasa, int goalCasa, String squadraTrasferta,
			int goalTrasferta) {
		super();
		this.id = id;
		this.nazione = nazione;
		this.tipoCompetizione = tipoCompetizione;
		this.turnoCompetizione = turnoCompetizione;
		this.annata = annata;
		this.data = data;
		this.ora = ora;
		this.squadraCasa = squadraCasa;
		this.goalCasa = goalCasa;
		this.squadraTrasferta = squadraTrasferta;
		this.goalTrasferta = goalTrasferta;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public String getTipoCompetizione() {
		return tipoCompetizione;
	}
	public void setTipoCompetizione(String tipoCompetizione) {
		this.tipoCompetizione = tipoCompetizione;
	}
	public String getTurnoCompetizione() {
		return turnoCompetizione;
	}
	public void setTurnoCompetizione(String turnoCompetizione) {
		this.turnoCompetizione = turnoCompetizione;
	}
	public String getAnnata() {
		return annata;
	}
	public void setAnnata(String annata) {
		this.annata = annata;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public String getSquadraCasa() {
		return squadraCasa;
	}
	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}
	public int getGoalCasa() {
		return goalCasa;
	}
	public void setGoalCasa(int goalCasa) {
		this.goalCasa = goalCasa;
	}
	public String getSquadraTrasferta() {
		return squadraTrasferta;
	}
	public void setSquadraTrasferta(String squadraTrasferta) {
		this.squadraTrasferta = squadraTrasferta;
	}
	public int getGoalTrasferta() {
		return goalTrasferta;
	}
	public void setGoalTrasferta(int goalTrasferta) {
		this.goalTrasferta = goalTrasferta;
	}

	@Override
	public String toString() {
		return "Partita [id=" + id + ", nazione=" + nazione + ", tipoCompetizione=" + tipoCompetizione
				+ ", turnoCompetizione=" + turnoCompetizione + ", annata=" + annata + ", data=" + data + ", ora=" + ora
				+ ", squadraCasa=" + squadraCasa + ", goalCasa=" + goalCasa + ", squadraTrasferta=" + squadraTrasferta
				+ ", goalTrasferta=" + goalTrasferta + "]";
	}




	
	
	
	
	
}
