package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Languages database table.
 * 
 */
@Entity
@Table(name="Languages")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int languageId;

	private String name;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="language")
	private List<AspNetUser> aspNetUsers;

	//bi-directional many-to-one association to UsersLanguge
	@OneToMany(mappedBy="language")
	private List<UsersLanguge> usersLanguges;

	public Language() {
	}

	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
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
		aspNetUser.setLanguage(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setLanguage(null);

		return aspNetUser;
	}

	public List<UsersLanguge> getUsersLanguges() {
		return this.usersLanguges;
	}

	public void setUsersLanguges(List<UsersLanguge> usersLanguges) {
		this.usersLanguges = usersLanguges;
	}

	public UsersLanguge addUsersLanguge(UsersLanguge usersLanguge) {
		getUsersLanguges().add(usersLanguge);
		usersLanguge.setLanguage(this);

		return usersLanguge;
	}

	public UsersLanguge removeUsersLanguge(UsersLanguge usersLanguge) {
		getUsersLanguges().remove(usersLanguge);
		usersLanguge.setLanguage(null);

		return usersLanguge;
	}

}