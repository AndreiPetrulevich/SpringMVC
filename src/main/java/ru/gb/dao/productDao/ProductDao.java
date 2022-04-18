package ru.gb.dao.productDao;

import ru.gb.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProducts();
    Product findProductByID(Long id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);
    void updateProduct(Product product);
}
