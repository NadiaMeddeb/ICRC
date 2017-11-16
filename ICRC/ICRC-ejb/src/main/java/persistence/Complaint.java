package persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Complaints database table.
 * 
 */
@Entity
@Table(name="Complaints")
@NamedQuery(name="Complaint.findAll", query="SELECT c FROM Complaint c")
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ComplaintId")
	private int complaintId;

	@Column(name="Description")
	private String description;

	@Column(name="Priority")
	private int priority;

	@Column(name="Receiver")
	private String receiver;

	@Column(name="Sender")
	private String sender;

	@Column(name="Subject")
	private String subject;

	@Column(name="Treated")
	private boolean treated;

	public Complaint() {
	}

	public int getComplaintId() {
		return this.complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean getTreated() {
		return this.treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}

}