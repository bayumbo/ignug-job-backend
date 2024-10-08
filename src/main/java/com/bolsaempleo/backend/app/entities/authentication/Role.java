package com.bolsaempleo.backend.app.entities.authentication;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles",schema = "authentication")
public class Role implements Serializable{

    private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(generator = "UUID")
	@SuppressWarnings("deprecation")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="guard_name")
	private String guardName;

	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;



	public Role() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getGuardName() {
		return this.guardName;
	}

	public void setGuardName(String guardName) {
		this.guardName = guardName;
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

}
