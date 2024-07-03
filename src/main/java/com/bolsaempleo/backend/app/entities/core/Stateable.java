package com.bolsaempleo.backend.app.entities.core;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the stateables database table.
 * 
 */
@Entity
@Table(name="stateables")
@NamedQuery(name="Stateable.findAll", query="SELECT s FROM Stateable s")
public class Stateable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="stateable_id")
	private Long stateableId;

	@Column(name="stateable_type")
	private String stateableType;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to State
	@ManyToOne
	private State state;

	public Stateable() {
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

	public Long getStateableId() {
		return this.stateableId;
	}

	public void setStateableId(Long stateableId) {
		this.stateableId = stateableId;
	}

	public String getStateableType() {
		return this.stateableType;
	}

	public void setStateableType(String stateableType) {
		this.stateableType = stateableType;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

}