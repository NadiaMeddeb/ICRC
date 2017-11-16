package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Transactions database table.
 * 
 */
@Entity
@Table(name="Transactions")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private double amount;

	private String cause;

	private Timestamp date;

	private String type;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="employeeId")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Association
	@ManyToOne
	@JoinColumn(name="AssociationId")
	private Association association;

	//bi-directional many-to-one association to Camp
	@ManyToOne
	@JoinColumn(name="CampId")
	private Camp camp;

	//bi-directional many-to-one association to Donatoor
	@ManyToOne
	@JoinColumn(name="DonatoorId")
	private Donatoor donatoor;

	public Transaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCause() {
		return this.cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Association getAssociation() {
		return this.association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public Camp getCamp() {
		return this.camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public Donatoor getDonatoor() {
		return this.donatoor;
	}

	public void setDonatoor(Donatoor donatoor) {
		this.donatoor = donatoor;
	}

}