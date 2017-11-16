package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Cellules database table.
 * 
 */
@Entity
@Table(name="Cellules")
@NamedQuery(name="Cellule.findAll", query="SELECT c FROM Cellule c")
public class Cellule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CelluleId")
	private int celluleId;

	private String name;

	private String number;

	//bi-directional many-to-one association to Camp
	@ManyToOne
	private Camp camp;

	//bi-directional many-to-one association to Mobilum
	@OneToMany(mappedBy="cellule")
	private List<Mobilum> mobilums;

	public Cellule() {
	}

	public int getCelluleId() {
		return this.celluleId;
	}

	public void setCelluleId(int celluleId) {
		this.celluleId = celluleId;
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

	public Camp getCamp() {
		return this.camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public List<Mobilum> getMobilums() {
		return this.mobilums;
	}

	public void setMobilums(List<Mobilum> mobilums) {
		this.mobilums = mobilums;
	}

	public Mobilum addMobilum(Mobilum mobilum) {
		getMobilums().add(mobilum);
		mobilum.setCellule(this);

		return mobilum;
	}

	public Mobilum removeMobilum(Mobilum mobilum) {
		getMobilums().remove(mobilum);
		mobilum.setCellule(null);

		return mobilum;
	}

}