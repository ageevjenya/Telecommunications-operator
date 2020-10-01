package com.netcracker.app.domain.shop.services;

import com.netcracker.app.domain.shop.entities.Modem;
import com.netcracker.app.domain.shop.repositories.ModemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModemService extends AbstractDevicesService<Modem> {

    private final ModemRepository repository;

    public ModemService(ModemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Modem modem) {
        repository.saveAndFlush(modem);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Modem> getAllByName(String name) {
        return repository.getAllByName(name);
    }

    @Override
    public List<Modem> getAll() {
        return repository.findAll();
    }

    @Override
    public Modem getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void updateName(String name, int id) throws Exception {
        if (repository.existsById(id)) {
            Modem modem = repository.getById(id);
            modem.setName(name);
            repository.saveAndFlush(modem);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updatePrice(double price, int id) throws Exception {
        if (repository.existsById(id)) {
            Modem modem = repository.getById(id);
            modem.setPrice(price);
            repository.saveAndFlush(modem);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updateDescription(String description, int id) throws Exception {
        if (repository.existsById(id)) {
            Modem modem = repository.getById(id);
            modem.setDescription(description);
            repository.saveAndFlush(modem);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updateShortDescription(String shortDescription, int id) throws Exception {
        if (repository.existsById(id)) {
            Modem modem = repository.getById(id);
            modem.setShortDescription(shortDescription);
            repository.saveAndFlush(modem);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updateSpecifications(String specifications, int id) throws Exception {
        if (repository.existsById(id)) {
            Modem modem = repository.getById(id);
            modem.setSpecifications(specifications);
            repository.saveAndFlush(modem);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updateImgUrl(String imgUrl, int id) throws Exception {
        if (repository.existsById(id)) {
            Modem modem = repository.getById(id);
            modem.setImgUrl(imgUrl);
            repository.saveAndFlush(modem);
        } else {
            throw new Exception();
        }
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}
