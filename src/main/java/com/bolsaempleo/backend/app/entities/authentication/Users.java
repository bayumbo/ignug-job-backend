package com.bolsaempleo.backend.app.entities.authentication;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users",schema = "authentication")
public class Users implements Serializable{

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@SuppressWarnings("deprecation")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	private String avatar;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	@Column(name="blood_type_id")
	private Long bloodTypeId;

	@Column(name="civil_status_id")
	private Long civilStatusId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	private String email;

	@Column(name="email_verified_at")
	private Timestamp emailVerifiedAt;

	@Column(name="ethnic_origin_id")
	private Long ethnicOriginId;

	@Column(name="gender_id")
	private Long genderId;

	@Column(name="identification_type_id")
	private Long identificationTypeId;

	private String lastname;

	@Column(name="max_attempts")
	private Integer maxAttempts;

	private String name;

	private String password;

	@Column(name="password_changed")
	private Boolean passwordChanged;

	private String phone;

	@Column(name="remember_token")
	private String rememberToken;

	@Column(name="sex_id")
	private Long sexId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private String username;

	@ManyToMany
	private List<Role> roles; 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Long getBloodTypeId() {
		return this.bloodTypeId;
	}

	public void setBloodTypeId(Long bloodTypeId) {
		this.bloodTypeId = bloodTypeId;
	}

	public Long getCivilStatusId() {
		return this.civilStatusId;
	}

	public void setCivilStatusId(Long civilStatusId) {
		this.civilStatusId = civilStatusId;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getEmailVerifiedAt() {
		return this.emailVerifiedAt;
	}

	public void setEmailVerifiedAt(Timestamp emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public Long getEthnicOriginId() {
		return this.ethnicOriginId;
	}

	public void setEthnicOriginId(Long ethnicOriginId) {
		this.ethnicOriginId = ethnicOriginId;
	}

	public Long getGenderId() {
		return this.genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public Long getIdentificationTypeId() {
		return this.identificationTypeId;
	}

	public void setIdentificationTypeId(Long identificationTypeId) {
		this.identificationTypeId = identificationTypeId;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getMaxAttempts() {
		return this.maxAttempts;
	}

	public void setMaxAttempts(Integer maxAttempts) {
		this.maxAttempts = maxAttempts;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getPasswordChanged() {
		return this.passwordChanged;
	}

	public void setPasswordChanged(Boolean passwordChanged) {
		this.passwordChanged = passwordChanged;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRememberToken() {
		return this.rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public Long getSexId() {
		return this.sexId;
	}

	public void setSexId(Long sexId) {
		this.sexId = sexId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
}
