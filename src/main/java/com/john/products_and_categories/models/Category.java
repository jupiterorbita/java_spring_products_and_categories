package com.john.products_and_categories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

//..
@Entity
@Table(name="categories")
public class Category {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
// --------------------------------------------------
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
     name = "categories_products", 
     joinColumns = @JoinColumn(name = "category_id"), 
     inverseJoinColumns = @JoinColumn(name = "product_id")
 )
 private List<Product> products;
// -------------------------------------------------
 
 public Category() {}
 
 @PrePersist
 protected void onCreate() {
	 this.createdAt = new Date(); 
 }
 
 @PreUpdate
 protected void onUpdate() {
	 this.updatedAt = new Date(); 
 }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}
 
 
}


//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name="categories")
//public class Category {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@Column(updatable=false)
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date createdAt;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date updatedAt;
//	
//	private String name;
//	
////	=== M : M ================================================
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(
//			name = "categories_products",
//			joinColumns = @JoinColumn(name = "category_id"),
//			inverseJoinColumns = @JoinColumn(name = "product_id")
//			)
//	private List<Product> products;
////	===========================================================
//
//	public Category() {}
//	
//	//---------------------------------
//		@PrePersist
//		protected void onCreate(){
//		    this.createdAt = new Date();
//		}
//		@PreUpdate
//		protected void onUpdate(){
//		    this.updatedAt = new Date();
//		}
//	//--------------------------------
//
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public Date getCreatedAt() {
//			return createdAt;
//		}
//
//		public void setCreatedAt(Date createdAt) {
//			this.createdAt = createdAt;
//		}
//
//		public Date getUpdatedAt() {
//			return updatedAt;
//		}
//
//		public void setUpdatedAt(Date updatedAt) {
//			this.updatedAt = updatedAt;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public List<Product> getProducts() {
//			return products;
//		}
//
//		public void setProducts(List<Product> products) {
//			this.products = products;
//		}
//}
