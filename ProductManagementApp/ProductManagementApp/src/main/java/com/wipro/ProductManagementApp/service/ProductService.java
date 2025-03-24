package com.wipro.ProductManagementApp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ProductManagementApp.entity.Product;
import com.wipro.ProductManagementApp.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product addProduct(Product obj) {
        return repository.save(obj);
    }

    public String deleteProduct(int id) {
        if (repository.existsById((int) id)) {
            repository.deleteById((int) id);
            return "Product deleted";
        } else {
            return "Product not found";
        }
    }

    public Optional<Product> getProduct(int id) {
        return repository.findById((int) id);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}
