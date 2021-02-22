package com.john.products_and_categories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.john.products_and_categories.models.Category;
import com.john.products_and_categories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
//	return Products that a Category is NOT in
	List<Product> findByCategoriesNotContaining(Category category);
	
//	return products of a category is in
	List<Product> findByCategoriesContaining(Category category);
	
// 	  this method finds books with descriptions containing the search string
//    List<Book> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
//	  List<Person> findByLicenseIsNull();
//	List<Product> findByLicenseIsNull();
}
