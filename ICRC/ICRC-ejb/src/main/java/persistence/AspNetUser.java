package persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the AspNetUsers database table.
 * 
 */
@Entity
@Table(name="AspNetUsers")
@NamedQuery(name="AspNetUser.findAll", query="SELECT a FROM AspNetUser a")
public class AspNetUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private String id;

	@Column(name="AccessFailedCount")
	private int accessFailedCount;

	@Column(name="Adress")
	private String adress;

	@Column(name="Balance")
	private double balance;

	private String country;

	@Column(name="Discriminator")
	private String discriminator;

	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="LastName")
	private String lastName;

	@Column(name="LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private Timestamp lockoutEndDateUtc;

	@Column(name="PasswordHash")
	private String passwordHash;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name="Picture")
	private String picture;

	@Column(name="SecurityStamp")
	private String securityStamp;

	@Column(name="Sexe")
	private String sexe;

	private int status;

	@Column(name="TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name="UserName")
	private String userName;

	//bi-directional many-to-one association to AdvertismentVolenteer
	@OneToMany(mappedBy="aspNetUser")
	private List<AdvertismentVolenteer> advertismentVolenteers;

	//bi-directional many-to-one association to AspNetUserClaim
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserClaim> aspNetUserClaims;

	//bi-directional many-to-one association to AspNetUserLogin
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserLogin> aspNetUserLogins;

	//bi-directional many-to-many association to AspNetRole
	@ManyToMany
	@JoinTable(
		name="AspNetUserRoles"
		, joinColumns={
			@JoinColumn(name="UserId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="RoleId")
			}
		)
	private List<AspNetRole> aspNetRoles;

	//bi-directional many-to-one association to Camp
	@ManyToOne
	private Camp camp;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="Language_languageId")
	private Language language;

	//bi-directional many-to-one association to Mobilum
	@ManyToOne
	@JoinColumn(name="MobilumId")
	private Mobilum mobilum;

	//bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy="aspNetUser")
	private List<Evaluation> evaluations;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="aspNetUser")
	private List<Event> events;

	//bi-directional many-to-one association to Leave
	@OneToMany(mappedBy="aspNetUser")
	private List<Leave> leaves;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="aspNetUser")
	private List<Transaction> transactions;

	//bi-directional many-to-one association to UsersLanguge
	@OneToMany(mappedBy="aspNetUser")
	private List<UsersLanguge> usersLanguges;

	public AspNetUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<AdvertismentVolenteer> getAdvertismentVolenteers() {
		return this.advertismentVolenteers;
	}

	public void setAdvertismentVolenteers(List<AdvertismentVolenteer> advertismentVolenteers) {
		this.advertismentVolenteers = advertismentVolenteers;
	}

	public AdvertismentVolenteer addAdvertismentVolenteer(AdvertismentVolenteer advertismentVolenteer) {
		getAdvertismentVolenteers().add(advertismentVolenteer);
		advertismentVolenteer.setAspNetUser(this);

		return advertismentVolenteer;
	}

	public AdvertismentVolenteer removeAdvertismentVolenteer(AdvertismentVolenteer advertismentVolenteer) {
		getAdvertismentVolenteers().remove(advertismentVolenteer);
		advertismentVolenteer.setAspNetUser(null);

		return advertismentVolenteer;
	}

	public List<AspNetUserClaim> getAspNetUserClaims() {
		return this.aspNetUserClaims;
	}

	public void setAspNetUserClaims(List<AspNetUserClaim> aspNetUserClaims) {
		this.aspNetUserClaims = aspNetUserClaims;
	}

	public AspNetUserClaim addAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().add(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(this);

		return aspNetUserClaim;
	}

	public AspNetUserClaim removeAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().remove(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(null);

		return aspNetUserClaim;
	}

	public List<AspNetUserLogin> getAspNetUserLogins() {
		return this.aspNetUserLogins;
	}

	public void setAspNetUserLogins(List<AspNetUserLogin> aspNetUserLogins) {
		this.aspNetUserLogins = aspNetUserLogins;
	}

	public AspNetUserLogin addAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().add(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(this);

		return aspNetUserLogin;
	}

	public AspNetUserLogin removeAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().remove(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(null);

		return aspNetUserLogin;
	}

	public List<AspNetRole> getAspNetRoles() {
		return this.aspNetRoles;
	}

	public void setAspNetRoles(List<AspNetRole> aspNetRoles) {
		this.aspNetRoles = aspNetRoles;
	}

	public Camp getCamp() {
		return this.camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Mobilum getMobilum() {
		return this.mobilum;
	}

	public void setMobilum(Mobilum mobilum) {
		this.mobilum = mobilum;
	}

	public List<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Evaluation addEvaluation(Evaluation evaluation) {
		getEvaluations().add(evaluation);
		evaluation.setAspNetUser(this);

		return evaluation;
	}

	public Evaluation removeEvaluation(Evaluation evaluation) {
		getEvaluations().remove(evaluation);
		evaluation.setAspNetUser(null);

		return evaluation;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setAspNetUser(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setAspNetUser(null);

		return event;
	}

	public List<Leave> getLeaves() {
		return this.leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	public Leave addLeave(Leave leave) {
		getLeaves().add(leave);
		leave.setAspNetUser(this);

		return leave;
	}

	public Leave removeLeave(Leave leave) {
		getLeaves().remove(leave);
		leave.setAspNetUser(null);

		return leave;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setAspNetUser(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setAspNetUser(null);

		return transaction;
	}

	public List<UsersLanguge> getUsersLanguges() {
		return this.usersLanguges;
	}

	public void setUsersLanguges(List<UsersLanguge> usersLanguges) {
		this.usersLanguges = usersLanguges;
	}

	public UsersLanguge addUsersLanguge(UsersLanguge usersLanguge) {
		getUsersLanguges().add(usersLanguge);
		usersLanguge.setAspNetUser(this);

		return usersLanguge;
	}

	public UsersLanguge removeUsersLanguge(UsersLanguge usersLanguge) {
		getUsersLanguges().remove(usersLanguge);
		usersLanguge.setAspNetUser(null);

		return usersLanguge;
	}

}