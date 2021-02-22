//package com.john.products_and_categories.models;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name="categories_products")
//public class CategoryProduct {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//	@Column(updatable=false)
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date createdAt;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date updatedAt;
//	
////	==== TABLE JOIN PRODUCT =============
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name="product_id")
//	private Product products;
//	
////	==== TABLE JOIN CATEGORY ============
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name="category_id")
//	private Category categories;
////	=====================================
//
//	public CategoryProduct() {}
//	
////	-------------------------------
//	@PrePersist
//	protected void onCreate(){
//	    this.createdAt = new Date();
//	}
//	@PreUpdate
//	protected void onUpdate(){
//	    this.updatedAt = new Date();
//	}
////	-----------------------------
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	public Product getProducts() {
//		return products;
//	}
//
//	public void setProducts(Product products) {
//		this.products = products;
//	}
//
//	public Category getCategories() {
//		return categories;
//	}
//
//	public void setCategories(Category categories) {
//		this.categories = categories;
//	}
//}
