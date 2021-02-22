package com.john.products_and_categories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.john.products_and_categories.models.Category;
import com.john.products_and_categories.models.Product;
import com.john.products_and_categories.services.CategoryService;
import com.john.products_and_categories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	private ProductService prodServ;
	@Autowired
	private CategoryService cateServ;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
//	======== CREATE PRODUCT =========================
	@GetMapping("/products/new")
	public String newProductPage(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product,
						BindingResult result) {
		if (result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			prodServ.createProduct(product);
			return "redirect:/products/" + product.getId();
//			return "redirect:/products/new";
		}
	}
	
//	======== CREATE CATEGORY ============================
	@GetMapping("/categories/new")
	public String newCategoryPage(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category,
						BindingResult result) {
		if (result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			cateServ.createCategory(category);
			return "redirect:/categories/"+category.getId();
		}
	}
	
//	===== show Products -> Categories ==================
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable Long id, Model x) {
//		error page
		if (prodServ.findProduct(id) == null) {
			return "error.jsp";
		}
		
		Product thisProduct = prodServ.findProduct(id);
		x.addAttribute("product", thisProduct);

//		for drop down to select only categories that are not part of product
		List<Category> prodNullCategories = cateServ.findByProductNotContaining(thisProduct);
		x.addAttribute("categoriesList", prodNullCategories);
		
//		show only categories of thisProduct
		List<Category> thisProductCategories = cateServ.findByProductContaining(thisProduct);
		x.addAttribute("thisProductCategories", thisProductCategories);

		return "/products/show.jsp";
	}
	@PostMapping("/products/{id}")
	public String addProductToCategory(@PathVariable Long id,
									@RequestParam Long categoryId) {
		Category cat = cateServ.findCategory(categoryId);
		Product prod = prodServ.findProduct(id);
//		System.out.println(prod.getName() +":"+ prod.getCategories());
		prod.getCategories().add(cat);
		prodServ.updateProduct(prod);
		return "redirect:/products/" + id;
	}
	
	
//	===== show CATEGORIES -> Products ==================
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable Long id, Model x) {		
//		error page
		if (cateServ.findCategory(id) == null) {
			return "error.jsp";
		}
		
		Category thisCategory = cateServ.findCategory(id);
		x.addAttribute("category", thisCategory);
		
//		for drop down to select only PRODUCTS that are not part of a category
		List<Product> availProducts = prodServ.findByCategoryNotContaining(thisCategory);
		x.addAttribute("productsList", availProducts);
		
//		show only products of thisCategory
		List<Product> thisCategoryProducts = prodServ.findByCategoryContaining(thisCategory);
		x.addAttribute("thisCategoriesHasProducts", thisCategoryProducts);
		
		return "/categories/show.jsp";
	}
	@PostMapping("/categories/{id}")
	public String addCategoryToProduct(@PathVariable Long id,
			@RequestParam Long productId) {
		
		Product prod = prodServ.findProduct(productId);
		Category cat = cateServ.findCategory(id);
		
		cat.getProducts().add(prod);
		cateServ.updateCategory(cat);

		return "redirect:/categories/" + id;
	}
	
//	--------- EXTRA main table with counts ----------------------
	
	
	
	
	
	
	
}
