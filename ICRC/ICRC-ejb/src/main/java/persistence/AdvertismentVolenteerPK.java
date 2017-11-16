package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AdvertismentVolenteers database table.
 * 
 */
@Embeddable
public class AdvertismentVolenteerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="AdvertisementId", insertable=false, updatable=false)
	private int advertisementId;

	@Column(insertable=false, updatable=false)
	private String volenteerId;

	public AdvertismentVolenteerPK() {
	}
	public int getAdvertisementId() {
		return this.advertisementId;
	}
	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}
	public String getVolenteerId() {
		return this.volenteerId;
	}
	public void setVolenteerId(String volenteerId) {
		this.volenteerId = volenteerId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + advertisementId;
		result = prime * result + ((volenteerId == null) ? 0 : volenteerId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdvertismentVolenteerPK other = (AdvertismentVolenteerPK) obj;
		if (advertisementId != other.advertisementId)
			return false;
		if (volenteerId == null) {
			if (other.volenteerId != null)
				return false;
		} else if (!volenteerId.equals(other.volenteerId))
			return false;
		return true;
	}

	
	
}