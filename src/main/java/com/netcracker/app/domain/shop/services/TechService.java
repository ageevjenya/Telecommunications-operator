package com.netcracker.app.domain.shop.services;

import com.netcracker.app.domain.shop.entities.Tech;
import com.netcracker.app.domain.shop.repositories.TechRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechService extends AbstractDevicesService<Tech> {

    private final TechRepository repository;

    public TechService(TechRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Tech tech) {
        repository.saveAndFlush(tech);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Tech> getAllByName(String name) {
        return repository.getAllByName(name);
    }

    @Override
    public List<Tech> getAll() {
        return repository.findAll();
    }

    @Override
    public Tech getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void updateName(String name, int id) throws Exception {
        if (repository.existsById(id)) {
            Tech tech = repository.getById(id);
            tech.setName(name);
            repository.saveAndFlush(tech);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updatePrice(double price, int id) throws Exception {
        if (repository.existsById(id)) {
            Tech tech = repository.getById(id);
            tech.setPrice(price);
            repository.saveAndFlush(tech);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updateDescription(String description, int id) throws Exception {
        if (repository.existsById(id)) {
            Tech tech = repository.getById(id);
            tech.setDescription(description);
            repository.saveAndFlush(tech);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updateShortDescription(String shortDescription, int id) throws Exception {
        if (repository.existsById(id)) {
            Tech tech = repository.getById(id);
            tech.setShortDescription(shortDescription);
            repository.saveAndFlush(tech);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updateSpecifications(String specifications, int id) throws Exception {
        if (repository.existsById(id)) {
            Tech tech = repository.getById(id);
            tech.setSpecifications(specifications);
            repository.saveAndFlush(tech);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void updateImgUrl(String imgUrl, int id) throws Exception {
        if (repository.existsById(id)) {
            Tech tech = repository.getById(id);
            tech.setImgUrl(imgUrl);
            repository.saveAndFlush(tech);
        } else {
            throw new Exception();
        }
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}
