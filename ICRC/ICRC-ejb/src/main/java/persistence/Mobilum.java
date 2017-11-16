package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Mobilums database table.
 * 
 */
@Entity
@Table(name="Mobilums")
@NamedQuery(name="Mobilum.findAll", query="SELECT m FROM Mobilum m")
public class Mobilum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int capacity;

	private String name;

	private String number;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="mobilum")
	private List<AspNetUser> aspNetUsers;

	//bi-directional many-to-one association to Cellule
	@ManyToOne
	@JoinColumn(name="CelluleId")
	private Cellule cellule;

	public Mobilum() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setMobilum(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setMobilum(null);

		return aspNetUser;
	}

	public Cellule getCellule() {
		return this.cellule;
	}

	public void setCellule(Cellule cellule) {
		this.cellule = cellule;
	}

}