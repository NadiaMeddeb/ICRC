package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Donatoors database table.
 * 
 */
@Entity
@Table(name="Donatoors")
@NamedQuery(name="Donatoor.findAll", query="SELECT d FROM Donatoor d")
public class Donatoor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DonatorId")
	private int donatorId;

	@Column(name="Adress")
	private String adress;

	@Column(name="Balance")
	private double balance;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="LastName")
	private String lastName;

	@Column(name="Login")
	private String login;

	@Column(name="Password")
	private String password;

	@Column(name="Sexe")
	private String sexe;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="donatoor")
	private List<Transaction> transactions;

	public Donatoor() {
	}

	public int getDonatorId() {
		return this.donatorId;
	}

	public void setDonatorId(int donatorId) {
		this.donatorId = donatorId;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setDonatoor(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setDonatoor(null);

		return transaction;
	}

}