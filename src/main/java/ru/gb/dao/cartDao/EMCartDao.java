package ru.gb.dao.cartDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Cart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class EMCartDao implements CartDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cart save(Cart cart) {
        if (cart.getId() == null) {
            entityManager.persist(cart);
        } else {
            entityManager.merge(cart);
        }
        return cart;
    }
}
