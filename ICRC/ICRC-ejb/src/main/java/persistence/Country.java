package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Countries database table.
 * 
 */
@Entity
@Table(name="Countries")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CountryId")
	private int countryId;

	@Column(name="Name")
	private String name;

	@Column(name="PIB")
	private double pib;

	@Column(name="Smig")
	private double smig;

	//bi-directional many-to-one association to Camp
	@OneToMany(mappedBy="country")
	private List<Camp> camps;

	public Country() {
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPib() {
		return this.pib;
	}

	public void setPib(double pib) {
		this.pib = pib;
	}

	public double getSmig() {
		return this.smig;
	}

	public void setSmig(double smig) {
		this.smig = smig;
	}

	public List<Camp> getCamps() {
		return this.camps;
	}

	public void setCamps(List<Camp> camps) {
		this.camps = camps;
	}

	public Camp addCamp(Camp camp) {
		getCamps().add(camp);
		camp.setCountry(this);

		return camp;
	}

	public Camp removeCamp(Camp camp) {
		getCamps().remove(camp);
		camp.setCountry(null);

		return camp;
	}

}