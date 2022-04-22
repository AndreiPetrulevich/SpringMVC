package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dao.manufacturerDao.EMManufacturerDAO;
import ru.gb.entity.Manufacturer;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final EMManufacturerDAO manufacturerDAO;

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }

    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerDAO.update(manufacturer);
    }

    public Iterable<Manufacturer> findAll() {
        return manufacturerDAO.findAll();
    }

    public Manufacturer findById(Long id) {
        return manufacturerDAO.findById(id);
    }

    public void deleteById(Long id) {
        manufacturerDAO.deleteById(id);
    }
}
