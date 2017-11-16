package persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AdvertismentVolenteers database table.
 * 
 */
@Entity
@Table(name="AdvertismentVolenteers")
@NamedQuery(name="AdvertismentVolenteer.findAll", query="SELECT a FROM AdvertismentVolenteer a")
public class AdvertismentVolenteer implements Serializable {
	private static final long serialVersionUID = 1L;



	@EmbeddedId
	private AdvertismentVolenteerPK id;

	private String cv;

	private String description;

	//bi-directional many-to-one association to Advertisement
	@ManyToOne
	@JoinColumn(name="AdvertisementId", insertable=false, updatable=false)
	private Advertisement advertisement;

	
	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="volenteerId", insertable=false, updatable=false)
	private AspNetUser aspNetUser;

	public AdvertismentVolenteer() {
	}

	public AdvertismentVolenteerPK getId() {
		return this.id;
	}

	public void setId(AdvertismentVolenteerPK id) {
		this.id = id;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Advertisement getAdvertisement() {
		return this.advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}