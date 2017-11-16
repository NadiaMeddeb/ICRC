package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Camps database table.
 * 
 */
@Entity
@Table(name="Camps")
@NamedQuery(name="Camp.findAll", query="SELECT c FROM Camp c")
public class Camp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CampId")
	private int campId;

	@Column(name="Balance")
	private double balance;

	private String name;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="camp")
	private List<AspNetUser> aspNetUsers;

	//bi-directional many-to-one association to Country
	@ManyToOne
	private Country country;

	//bi-directional many-to-one association to Cellule
	@OneToMany(mappedBy="camp")
	private List<Cellule> cellules;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="camp")
	private List<Transaction> transactions;

	public Camp() {
	}

	public int getCampId() {
		return this.campId;
	}

	public void setCampId(int campId) {
		this.campId = campId;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setCamp(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setCamp(null);

		return aspNetUser;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Cellule> getCellules() {
		return this.cellules;
	}

	public void setCellules(List<Cellule> cellules) {
		this.cellules = cellules;
	}

	public Cellule addCellule(Cellule cellule) {
		getCellules().add(cellule);
		cellule.setCamp(this);

		return cellule;
	}

	public Cellule removeCellule(Cellule cellule) {
		getCellules().remove(cellule);
		cellule.setCamp(null);

		return cellule;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setCamp(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setCamp(null);

		return transaction;
	}

}