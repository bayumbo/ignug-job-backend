package com.bolsaempleo.backend.app.entities.core;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the socialmediables database table.
 * 
 */
@Entity
@Table(name="socialmediables")
@NamedQuery(name="Socialmediable.findAll", query="SELECT s FROM Socialmediable s")
public class Socialmediable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="socialmediables_id")
	private Long socialmediablesId;

	@Column(name="socialmediables_type")
	private String socialmediablesType;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private String url;

	private String user;

	//bi-directional many-to-one association to Socialmedia
	@ManyToOne
	private Socialmedia socialmedia;

	public Socialmediable() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Long getSocialmediablesId() {
		return this.socialmediablesId;
	}

	public void setSocialmediablesId(Long socialmediablesId) {
		this.socialmediablesId = socialmediablesId;
	}

	public String getSocialmediablesType() {
		return this.socialmediablesType;
	}

	public void setSocialmediablesType(String socialmediablesType) {
		this.socialmediablesType = socialmediablesType;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Socialmedia getSocialmedia() {
		return this.socialmedia;
	}

	public void setSocialmedia(Socialmedia socialmedia) {
		this.socialmedia = socialmedia;
	}

}