package persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AspNetUserRoles database table.
 * 
 */
@Entity
@Table(name="AspNetUserRoles")
@NamedQuery(name="AspNetUserRole.findAll", query="SELECT a FROM AspNetUserRole a")
public class AspNetUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AspNetUserRolePK id;

	//bi-directional many-to-one association to AspNetRole
	@ManyToOne
	@JoinColumn(name="RoleId", insertable=false, updatable=false)
	private AspNetRole aspNetRole;

	public AspNetUserRole() {
	}

	public AspNetUserRolePK getId() {
		return this.id;
	}

	public void setId(AspNetUserRolePK id) {
		this.id = id;
	}

	public AspNetRole getAspNetRole() {
		return this.aspNetRole;
	}

	public void setAspNetRole(AspNetRole aspNetRole) {
		this.aspNetRole = aspNetRole;
	}

}