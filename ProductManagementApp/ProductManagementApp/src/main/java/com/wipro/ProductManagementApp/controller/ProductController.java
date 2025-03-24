package com.wipro.ProductManagementApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.ProductManagementApp.entity.Product;
import com.wipro.ProductManagementApp.service.ProductService;
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product obj) {
		Product p=  service.addProduct(obj);
		  
		  return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product>  getProduct(@PathVariable int id) {
		Optional<Product> product = service.getProduct(id);

		if (product.isPresent()) {
			 return new ResponseEntity<>(product.get(), HttpStatus.OK);
		} else
			 return new ResponseEntity<>(new Product(), HttpStatus.NOT_FOUND);
	}	

	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> list= service.getProducts();
		  return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public String saveProduct(@PathVariable int id) {
		return service.deleteProduct(id);

	}
	

}