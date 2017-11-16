package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Produits database table.
 * 
 */
@Entity
@Table(name="Produits")
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProduitId")
	private int produitId;

	private String category;

	private String image;

	private float prixUnitaire;

	private String reference;

	private int tax;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="produit")
	private List<Stock> stocks;

	//bi-directional many-to-one association to LigneCMD
	@OneToMany(mappedBy="produit")
	private List<LigneCMD> ligneCmds;

	public Produit() {
	}

	public int getProduitId() {
		return this.produitId;
	}

	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getTax() {
		return this.tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setProduit(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setProduit(null);

		return stock;
	}

	public List<LigneCMD> getLigneCmds() {
		return this.ligneCmds;
	}

	public void setLigneCmds(List<LigneCMD> ligneCmds) {
		this.ligneCmds = ligneCmds;
	}

	public LigneCMD addLigneCmd(LigneCMD ligneCmd) {
		getLigneCmds().add(ligneCmd);
		ligneCmd.setProduit(this);

		return ligneCmd;
	}

	public LigneCMD removeLigneCmd(LigneCMD ligneCmd) {
		getLigneCmds().remove(ligneCmd);
		ligneCmd.setProduit(null);

		return ligneCmd;
	}

}