package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AspNetUserLogins database table.
 * 
 */
@Embeddable
public class AspNetUserLoginPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="LoginProvider")
	private String loginProvider;

	@Column(name="ProviderKey")
	private String providerKey;

	@Column(name="UserId", insertable=false, updatable=false)
	private String userId;

	public AspNetUserLoginPK() {
	}
	public String getLoginProvider() {
		return this.loginProvider;
	}
	public void setLoginProvider(String loginProvider) {
		this.loginProvider = loginProvider;
	}
	public String getProviderKey() {
		return this.providerKey;
	}
	public void setProviderKey(String providerKey) {
		this.providerKey = providerKey;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginProvider == null) ? 0 : loginProvider.hashCode());
		result = prime * result + ((providerKey == null) ? 0 : providerKey.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		AspNetUserLoginPK other = (AspNetUserLoginPK) obj;
		if (loginProvider == null) {
			if (other.loginProvider != null)
				return false;
		} else if (!loginProvider.equals(other.loginProvider))
			return false;
		if (providerKey == null) {
			if (other.providerKey != null)
				return false;
		} else if (!providerKey.equals(other.providerKey))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


}