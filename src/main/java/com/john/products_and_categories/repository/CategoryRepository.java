package com.john.products_and_categories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.john.products_and_categories.models.Category;
import com.john.products_and_categories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
//	return categories that a product is NOT in
	List<Category> findByProductsNotContaining(Product product);
	
//	return categories of a product is in
	List<Category> findByProductsContaining(Product product);
	
// 	  this method finds books with descriptions containing the search string
//    List<Book> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
//	  List<Person> findByLicenseIsNull();
}
