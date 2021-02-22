package com.john.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.john.products_and_categories.models.Category;
import com.john.products_and_categories.models.Product;
import com.john.products_and_categories.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository prodRepo;
	
//	READ ALL
	public List<Product> allProducts(){
		return prodRepo.findAll();
	}
//	CREATE
	public Product createProduct(Product p) {
		return prodRepo.save(p);
	}
//	UPDATE
	public Product updateProduct(Product p) {
		return prodRepo.save(p);
	}
//	READ ONE
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = prodRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
//	DELETE
	public void deleteProduct(Long id) {
		prodRepo.deleteById(id);
	}

//	Find PRODUCT with NO CATEGORY
	public List<Product> findByCategoryNotContaining(Category c) {
		return prodRepo.findByCategoriesNotContaining(c);
	}
//	Find PRODUCTS WITH CATEGORIES!
	public List<Product> findByCategoryContaining(Category c) {
		return prodRepo.findByCategoriesContaining(c);
	}
}
