package com.bolsaempleo.backend.app.entities.core;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the socialmedia database table.
 * 
 */
@Entity
@Table(name="socialmedia",schema = "core")
@NamedQuery(name="Socialmedia.findAll", query="SELECT s FROM Socialmedia s")
public class Socialmedia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	private String icon;

	private String logo;

	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Socialmediable
	@OneToMany(mappedBy="socialmedia")
	private List<Socialmediable> socialmediables;

	public Socialmedia() {
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

	public Timestamp getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Socialmediable> getSocialmediables() {
		return this.socialmediables;
	}

	public void setSocialmediables(List<Socialmediable> socialmediables) {
		this.socialmediables = socialmediables;
	}

	public Socialmediable addSocialmediable(Socialmediable socialmediable) {
		getSocialmediables().add(socialmediable);
		socialmediable.setSocialmedia(this);

		return socialmediable;
	}

	public Socialmediable removeSocialmediable(Socialmediable socialmediable) {
		getSocialmediables().remove(socialmediable);
		socialmediable.setSocialmedia(null);

		return socialmediable;
	}

}