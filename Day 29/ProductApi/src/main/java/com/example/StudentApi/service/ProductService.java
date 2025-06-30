package com.example.StudentApi.service;

import com.example.StudentApi.model.Product;
import com.example.StudentApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product student) {
        productRepository.save(student);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public double calculateDiscountedPrice(Long id) {
        Product product = productRepository.findById(id).get();
        double price = product.getPrice();
        int discountPercentage = product.getDiscountPercentage();
        double disPrice = price - (price * discountPercentage)/100;
        return disPrice;
    }
}
