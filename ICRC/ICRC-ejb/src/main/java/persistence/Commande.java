package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Commandes database table.
 * 
 */
@Entity
@Table(name="Commandes")
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CommandeId")
	private int commandeId;

	private Timestamp dateCreation;

	private Timestamp dateReception;

	@Column(name="Livraison")
	private String livraison;

	private String paiement;

	@Column(name="Reference")
	private String reference;

	@Column(name="Status")
	private String status;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="FournisseurId")
	private Fournisseur fournisseur;

	//bi-directional many-to-one association to LigneCMD
	@OneToMany(mappedBy="commande")
	private List<LigneCMD> ligneCmds;

	public Commande() {
	}

	public int getCommandeId() {
		return this.commandeId;
	}

	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}

	public Timestamp getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Timestamp getDateReception() {
		return this.dateReception;
	}

	public void setDateReception(Timestamp dateReception) {
		this.dateReception = dateReception;
	}

	public String getLivraison() {
		return this.livraison;
	}

	public void setLivraison(String livraison) {
		this.livraison = livraison;
	}

	public String getPaiement() {
		return this.paiement;
	}

	public void setPaiement(String paiement) {
		this.paiement = paiement;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneCMD> getLigneCmds() {
		return this.ligneCmds;
	}

	public void setLigneCmds(List<LigneCMD> ligneCmds) {
		this.ligneCmds = ligneCmds;
	}

	public LigneCMD addLigneCmd(LigneCMD ligneCmd) {
		getLigneCmds().add(ligneCmd);
		ligneCmd.setCommande(this);

		return ligneCmd;
	}

	public LigneCMD removeLigneCmd(LigneCMD ligneCmd) {
		getLigneCmds().remove(ligneCmd);
		ligneCmd.setCommande(null);

		return ligneCmd;
	}

}