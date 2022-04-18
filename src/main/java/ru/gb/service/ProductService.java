package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dao.productDao.EMProductDao;
import ru.gb.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final EMProductDao productDao;

    public Product saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    public Product findProductById(Integer id) {
        return productDao.findProductById(id);
    }

    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }
    public void deleteProductById(Integer id) {
        productDao.deleteProductById(id);
    }
}
