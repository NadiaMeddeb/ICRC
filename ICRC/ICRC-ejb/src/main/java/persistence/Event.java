package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Events database table.
 * 
 */
@Entity
@Table(name="Events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EventId")
	private int eventId;

	private Timestamp endDay;

	private int eventType;

	private String image;

	private String name;

	private String place;

	@Column(name="StartDate")
	private Timestamp startDate;

	//bi-directional many-to-one association to Advertisement
	@ManyToOne
	@JoinColumn(name="AdvertisementId")
	private Advertisement advertisement;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="adminId")
	private AspNetUser aspNetUser;

	public Event() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Timestamp getEndDay() {
		return this.endDay;
	}

	public void setEndDay(Timestamp endDay) {
		this.endDay = endDay;
	}

	public int getEventType() {
		return this.eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
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