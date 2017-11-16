package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Evaluations database table.
 * 
 */
@Entity
@Table(name="Evaluations")
@NamedQuery(name="Evaluation.findAll", query="SELECT e FROM Evaluation e")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp dateofevaluation;

	private double evalutaion;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="user_Id")
	private AspNetUser aspNetUser;

	public Evaluation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateofevaluation() {
		return this.dateofevaluation;
	}

	public void setDateofevaluation(Timestamp dateofevaluation) {
		this.dateofevaluation = dateofevaluation;
	}

	public double getEvalutaion() {
		return this.evalutaion;
	}

	public void setEvalutaion(double evalutaion) {
		this.evalutaion = evalutaion;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}