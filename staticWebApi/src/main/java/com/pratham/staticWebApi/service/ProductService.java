package com.pratham.staticWebApi.service;

import com.pratham.staticWebApi.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 80000),
            new Product(102, "Samsung", 90000),
            new Product(103, "Redmi", 40000)));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(new Product(0, "No Such Product", 0));
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public int deleteProduct(int id) {
        products.remove(products.stream().filter(p -> p.getId() == id).findFirst().get());
        return id;
    }

    public Product updateProduct(int id, Product product) {
        products.set(products.indexOf(products.stream().filter(p -> p.getId() == id).findFirst().get()), product);
        return product;
    }
}
