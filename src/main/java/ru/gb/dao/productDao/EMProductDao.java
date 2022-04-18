package ru.gb.dao.productDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class EMProductDao implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAllProducts() {
        return entityManager.createNamedQuery("Product.findAllProducts").getResultList();
    }

    @Override
    public Product findProductByID(Long id) {
        TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.findProductByID", Product.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    @Override
    public Product saveProduct(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        return product;
    }

    @Override
    public void deleteProductById(Integer id) {
        Product product = new Product();
        product.setId(id);
        try {
            Product mergeProduct = entityManager.merge(product);
            entityManager.remove(mergeProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.refresh(product);
    }
}
