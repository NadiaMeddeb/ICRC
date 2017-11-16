package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Advertisements database table.
 * 
 */
@Entity
@Table(name="Advertisements")
@NamedQuery(name="Advertisement.findAll", query="SELECT a FROM Advertisement a")
public class Advertisement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AdvertisementId")
	private int advertisementId;

	@Column(name="AdvertismentName")
	private String advertismentName;

	@Column(name="Description")
	private String description;

	private boolean display;

	private Timestamp endDay;

	private String place;

	private int skill;

	@Column(name="StartDate")
	private Timestamp startDate;

	//bi-directional many-to-one association to AdvertismentVolenteer
	@OneToMany(mappedBy="advertisement")
	private List<AdvertismentVolenteer> advertismentVolenteers;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="advertisement")
	private List<Event> events;

	public Advertisement() {
	}

	public int getAdvertisementId() {
		return this.advertisementId;
	}

	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getAdvertismentName() {
		return this.advertismentName;
	}

	public void setAdvertismentName(String advertismentName) {
		this.advertismentName = advertismentName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getDisplay() {
		return this.display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public Timestamp getEndDay() {
		return this.endDay;
	}

	public void setEndDay(Timestamp endDay) {
		this.endDay = endDay;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getSkill() {
		return this.skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public List<AdvertismentVolenteer> getAdvertismentVolenteers() {
		return this.advertismentVolenteers;
	}

	public void setAdvertismentVolenteers(List<AdvertismentVolenteer> advertismentVolenteers) {
		this.advertismentVolenteers = advertismentVolenteers;
	}

	public AdvertismentVolenteer addAdvertismentVolenteer(AdvertismentVolenteer advertismentVolenteer) {
		getAdvertismentVolenteers().add(advertismentVolenteer);
		advertismentVolenteer.setAdvertisement(this);

		return advertismentVolenteer;
	}

	public AdvertismentVolenteer removeAdvertismentVolenteer(AdvertismentVolenteer advertismentVolenteer) {
		getAdvertismentVolenteers().remove(advertismentVolenteer);
		advertismentVolenteer.setAdvertisement(null);

		return advertismentVolenteer;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setAdvertisement(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setAdvertisement(null);

		return event;
	}

}