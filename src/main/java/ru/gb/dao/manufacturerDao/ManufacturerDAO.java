package ru.gb.dao.manufacturerDao;

import ru.gb.entity.Manufacturer;

public interface ManufacturerDAO {
    Iterable<Manufacturer> findAll();
    Manufacturer findById(Long id);
    void deleteById(Long id);
    void update(Manufacturer manufacturer);
    Manufacturer save(Manufacturer manufacturer);
    String findNameById(Long id);
}
