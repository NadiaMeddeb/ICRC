package persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Stocks database table.
 * 
 */
@Entity
@Table(name="Stocks")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StockId")
	private int stockId;

	private int quantite;

	private int quantiteAAcheter;

	private int quantiteAlerte;

	private int quantiteAtendu;

	private int quantiteIdeal;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="ProduitId")
	private Produit produit;

	public Stock() {
	}

	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getQuantiteAAcheter() {
		return this.quantiteAAcheter;
	}

	public void setQuantiteAAcheter(int quantiteAAcheter) {
		this.quantiteAAcheter = quantiteAAcheter;
	}

	public int getQuantiteAlerte() {
		return this.quantiteAlerte;
	}

	public void setQuantiteAlerte(int quantiteAlerte) {
		this.quantiteAlerte = quantiteAlerte;
	}

	public int getQuantiteAtendu() {
		return this.quantiteAtendu;
	}

	public void setQuantiteAtendu(int quantiteAtendu) {
		this.quantiteAtendu = quantiteAtendu;
	}

	public int getQuantiteIdeal() {
		return this.quantiteIdeal;
	}

	public void setQuantiteIdeal(int quantiteIdeal) {
		this.quantiteIdeal = quantiteIdeal;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}