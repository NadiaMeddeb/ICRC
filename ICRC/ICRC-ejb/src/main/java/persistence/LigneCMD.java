package persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ligneCMDs database table.
 * 
 */
@Entity
@Table(name="ligneCMDs")
@NamedQuery(name="LigneCMD.findAll", query="SELECT l FROM LigneCMD l")
public class LigneCMD implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LigneCMDPK id;

	private String description;

	private String quantite;
	

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="CommandeId", insertable=false, updatable=false)
	private Commande commande;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="ProduitId", insertable=false, updatable=false)
	private Produit produit;

	public LigneCMD() {
	}

	public LigneCMDPK getId() {
		return this.id;
	}

	public void setId(LigneCMDPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantite() {
		return this.quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}