package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="professionals", schema = "job_board")
@NamedQuery(name="Professional.findAll", query="SELECT p FROM Professional p")
public class Professional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
    @Setter
    private Long id;

	@Column(name="about_me")
	@Getter
    @Setter
    private String aboutMe;

	@Column(name="catastrophic_diseased")
	@Getter
    @Setter
    private Boolean catastrophicDiseased;

	@Column(name="created_at")
	@Getter
    @Setter
    private Timestamp createdAt;

	@Column(name="deleted_at")
	@Getter
    @Setter
    private Timestamp deletedAt;

	@Getter
    @Setter
    private Boolean disabled;

	@Column(name="familiar_catastrophic_diseased")
	@Getter
    @Setter
    private Boolean familiarCatastrophicDiseased;

	@Column(name="familiar_disabled")
	@Getter
    @Setter
    private Boolean familiarDisabled;

	@Column(name="identification_familiar_disabled")
	@Getter
    @Setter
    private String identificationFamiliarDisabled;

	@Getter
    @Setter
    private Boolean traveled;

	@Column(name="updated_at")
	@Getter
    @Setter
    private Timestamp updatedAt;

	@Column(name="user_id")
	@Getter
    @Setter
    private Long userId;
}