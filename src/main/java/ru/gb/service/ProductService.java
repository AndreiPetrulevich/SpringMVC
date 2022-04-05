package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public Product editProduct(Product product) {
        return productRepository.editProduct(product);
    }

    public Product getByID(Integer id) {
        return productRepository.getById(id).orElse(new Product());
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
    public void deleteById(Integer id) {
        productRepository.deleteProduct(id);
    }
}
