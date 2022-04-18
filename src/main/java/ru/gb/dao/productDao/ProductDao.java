package ru.gb.dao.productDao;

import ru.gb.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProducts();
    Product findProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);
    Product updateProduct(Product product);
}
