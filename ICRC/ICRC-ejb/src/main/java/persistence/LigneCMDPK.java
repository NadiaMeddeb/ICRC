package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ligneCMDs database table.
 * 
 */
@Embeddable
public class LigneCMDPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CommandeId", insertable=false, updatable=false)
	private int commandeId;

	@Column(name="ProduitId", insertable=false, updatable=false)
	private int produitId;

	public LigneCMDPK() {
	}
	public int getCommandeId() {
		return this.commandeId;
	}
	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}
	public int getProduitId() {
		return this.produitId;
	}
	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCMDPK other = (LigneCMDPK) obj;
		if (commandeId != other.commandeId)
			return false;
		if (produitId != other.produitId)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commandeId;
		result = prime * result + produitId;
		return result;
	}
}