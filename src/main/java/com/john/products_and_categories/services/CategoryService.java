package com.john.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.john.products_and_categories.models.Category;
import com.john.products_and_categories.models.Product;
import com.john.products_and_categories.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cateRepo;
	
//	READ ALL
	public List<Category> allCategories(){
		return cateRepo.findAll();
	}
//	CREATE
	public Category createCategory(Category c) {
		return cateRepo.save(c);
	}
//	UPDATE
	public Category updateCategory(Category c) {
		return cateRepo.save(c);
	}
//	READ ONE
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = cateRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}
//	DELETE
	public void deleteCategory(Long id) {
		cateRepo.deleteById(id);
	}
//	Find CATEGORY with NO PRODUCT
	public List<Category> findByProductNotContaining(Product p) {
		return cateRepo.findByProductsNotContaining(p);
	}
//	Find CATEGORIES WITH Products!
	public List<Category> findByProductContaining(Product p) {
		return cateRepo.findByProductsContaining(p);
	}
	

}
