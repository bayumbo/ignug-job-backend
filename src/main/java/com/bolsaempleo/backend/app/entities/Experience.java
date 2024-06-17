package com.bolsaempleo.backend.app.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the experiences database table.
 * 
 */
@Entity
@Table(name="experiences")
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Object activities;

	@Column(name="area_id")
	private Long areaId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	private String employer;

	@Temporal(TemporalType.DATE)
	@Column(name="ended_at")
	private Date endedAt;

	private String position;

	@Column(name="reason_leave")
	private String reasonLeave;

	@Temporal(TemporalType.DATE)
	@Column(name="started_at")
	private Date startedAt;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private Boolean worked;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	private Professional professional;

	public Experience() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Object getActivities() {
		return this.activities;
	}

	public void setActivities(Object activities) {
		this.activities = activities;
	}

	public Long getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getEmployer() {
		return this.employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public Date getEndedAt() {
		return this.endedAt;
	}

	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getReasonLeave() {
		return this.reasonLeave;
	}

	public void setReasonLeave(String reasonLeave) {
		this.reasonLeave = reasonLeave;
	}

	public Date getStartedAt() {
		return this.startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getWorked() {
		return this.worked;
	}

	public void setWorked(Boolean worked) {
		this.worked = worked;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}