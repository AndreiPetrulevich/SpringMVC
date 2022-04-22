package ru.gb.dao.manufacturerDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Manufacturer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class EMManufacturerDAO implements ManufacturerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Manufacturer> findAll() {
        return entityManager.createNamedQuery("Manufacturer.findAll").getResultList();
    }

    @Override
    public Manufacturer findById(Long id) {
        TypedQuery<Manufacturer> namedQuery = entityManager.createNamedQuery("Manufacturer.findById", Manufacturer.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    @Override
    public String findNameById(Long id) {
        TypedQuery<String> namedQuery = entityManager.createNamedQuery("Manufacturer.findNameById", String.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);
        try {
            delete(manufacturer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Manufacturer manufacturer) {
        Manufacturer mergeManufacturer = entityManager.merge(manufacturer);
        entityManager.remove(mergeManufacturer);
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        if (manufacturer.getId() == null) {
            entityManager.persist(manufacturer);
        } else {
            entityManager.refresh(manufacturer);
        }
        return manufacturer;
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        if (manufacturer.getId() == null) {
            entityManager.persist(manufacturer);
        } else {
            entityManager.merge(manufacturer);
        }
        return manufacturer;
    }


}
