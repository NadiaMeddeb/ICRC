package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AspNetRoles database table.
 * 
 */
@Entity
@Table(name="AspNetRoles")
@NamedQuery(name="AspNetRole.findAll", query="SELECT a FROM AspNetRole a")
public class AspNetRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private String id;

	@Column(name="Discriminator")
	private String discriminator;

	@Column(name="Name")
	private String name;

	@Column(name="Salary")
	private int salary;

	//bi-directional many-to-one association to AspNetUserRole
	@OneToMany(mappedBy="aspNetRole")
	private List<AspNetUserRole> aspNetUserRoles;

	//bi-directional many-to-many association to AspNetUser
	@ManyToMany(mappedBy="aspNetRoles")
	private List<AspNetUser> aspNetUsers;

	public AspNetRole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<AspNetUserRole> getAspNetUserRoles() {
		return this.aspNetUserRoles;
	}

	public void setAspNetUserRoles(List<AspNetUserRole> aspNetUserRoles) {
		this.aspNetUserRoles = aspNetUserRoles;
	}

	public AspNetUserRole addAspNetUserRole(AspNetUserRole aspNetUserRole) {
		getAspNetUserRoles().add(aspNetUserRole);
		aspNetUserRole.setAspNetRole(this);

		return aspNetUserRole;
	}

	public AspNetUserRole removeAspNetUserRole(AspNetUserRole aspNetUserRole) {
		getAspNetUserRoles().remove(aspNetUserRole);
		aspNetUserRole.setAspNetRole(null);

		return aspNetUserRole;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

}