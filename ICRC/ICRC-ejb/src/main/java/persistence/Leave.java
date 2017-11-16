package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Leaves database table.
 * 
 */
@Entity
@Table(name="Leaves")
@NamedQuery(name="Leave.findAll", query="SELECT l FROM Leave l")
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp dateDebut;

	private Timestamp dateFin;

	private boolean declared;

	private int dureeEnJour;

	private boolean etat;

	private String motif;

	private boolean vue;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="userId")
	private AspNetUser aspNetUser;

	public Leave() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Timestamp getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}

	public boolean getDeclared() {
		return this.declared;
	}

	public void setDeclared(boolean declared) {
		this.declared = declared;
	}

	public int getDureeEnJour() {
		return this.dureeEnJour;
	}

	public void setDureeEnJour(int dureeEnJour) {
		this.dureeEnJour = dureeEnJour;
	}

	public boolean getEtat() {
		return this.etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public boolean getVue() {
		return this.vue;
	}

	public void setVue(boolean vue) {
		this.vue = vue;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}