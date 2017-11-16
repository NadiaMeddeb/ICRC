package persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UsersLanguges database table.
 * 
 */
@Entity
@Table(name="UsersLanguges")
@NamedQuery(name="UsersLanguge.findAll", query="SELECT u FROM UsersLanguge u")
public class UsersLanguge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="Degree")
	private String degree;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="RefugeeId")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="LanguageId")
	private Language language;

	public UsersLanguge() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}