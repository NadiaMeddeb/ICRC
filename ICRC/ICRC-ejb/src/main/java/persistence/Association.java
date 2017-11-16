package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Associations database table.
 * 
 */
@Entity
@Table(name="Associations")
@NamedQuery(name="Association.findAll", query="SELECT a FROM Association a")
public class Association implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AssociationId")
	private int associationId;

	private double balance;

	private String name;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="association")
	private List<Transaction> transactions;

	public Association() {
	}

	public int getAssociationId() {
		return this.associationId;
	}

	public void setAssociationId(int associationId) {
		this.associationId = associationId;
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

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setAssociation(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setAssociation(null);

		return transaction;
	}

}