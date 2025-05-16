package com.pratham.staticWebApi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.pratham.staticWebApi.model.Product;
import com.pratham.staticWebApi.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product) {
        return service.addProduct(product) + " Added Successfully";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id) {
        return "Product with id " + service.deleteProduct(id) + " deleted successfully";
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }
}
