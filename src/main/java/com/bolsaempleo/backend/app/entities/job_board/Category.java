package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories",schema = "job_board")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@SuppressWarnings("deprecation")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;


	@Column(length=255)
	private String code;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Column(length=255)
	private String icon;

	@Column(nullable=false, length=2147483647)
	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to AcademicFormation
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private List<AcademicFormation> academicFormations;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Category category;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private List<Category> categories;

	//bi-directional many-to-one association to CategoryOffer
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private List<CategoryOffer> categoryOffers;

	//bi-directional many-to-one association to Cours
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private List<Cours> courses;

	public Category() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<AcademicFormation> getAcademicFormations() {
		return this.academicFormations;
	}

	public void setAcademicFormations(List<AcademicFormation> academicFormations) {
		this.academicFormations = academicFormations;
	}

	public AcademicFormation addAcademicFormation(AcademicFormation academicFormation) {
		getAcademicFormations().add(academicFormation);
		academicFormation.setCategory(this);

		return academicFormation;
	}

	public AcademicFormation removeAcademicFormation(AcademicFormation academicFormation) {
		getAcademicFormations().remove(academicFormation);
		academicFormation.setCategory(null);

		return academicFormation;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setCategory(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setCategory(null);

		return category;
	}

	public List<CategoryOffer> getCategoryOffers() {
		return this.categoryOffers;
	}

	public void setCategoryOffers(List<CategoryOffer> categoryOffers) {
		this.categoryOffers = categoryOffers;
	}

	public CategoryOffer addCategoryOffer(CategoryOffer categoryOffer) {
		getCategoryOffers().add(categoryOffer);
		categoryOffer.setCategory(this);

		return categoryOffer;
	}

	public CategoryOffer removeCategoryOffer(CategoryOffer categoryOffer) {
		getCategoryOffers().remove(categoryOffer);
		categoryOffer.setCategory(null);

		return categoryOffer;
	}

	public List<Cours> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Cours> courses) {
		this.courses = courses;
	}

	public Cours addCours(Cours cours) {
		getCourses().add(cours);
		cours.setCategory(this);

		return cours;
	}

	public Cours removeCours(Cours cours) {
		getCourses().remove(cours);
		cours.setCategory(null);

		return cours;
	}

}