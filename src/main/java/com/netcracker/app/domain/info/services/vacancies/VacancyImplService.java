package com.netcracker.app.domain.info.services.vacancies;

import com.netcracker.app.domain.info.entities.vacancies.Vacancy;
import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import com.netcracker.app.domain.info.repositories.vacancies.VacancyImplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyImplService implements VacancyService<VacancyImpl> {
    private VacancyImplRepository repository;

    @Autowired
    public VacancyImplService(VacancyImplRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(VacancyImpl vacancy) {
        repository.saveAndFlush(vacancy);
    }

    @Override
    public void updateName(String name, int id) {
        if (repository.existsById(id) && name != null) {
            VacancyImpl vacancy = repository.getById(id);
            vacancy.setName(name);
            repository.saveAndFlush(vacancy);
        }
    }

    @Override
    public void updateText(String text, int id) {
        if (repository.existsById(id) && text != null) {
            VacancyImpl vacancy = repository.getById(id);
            vacancy.setText(text);
            repository.saveAndFlush(vacancy);
        }
    }

    @Override
    public void delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<VacancyImpl> getAll() {
        return repository.findAll();
    }

    public VacancyImpl getByName(String name) {
        return repository.getByName(name);
    }

/*    @Override
    public Iterable<VacancyImpl> getAllByName(String name) {
        return null;
    }*/


    @Override
    public VacancyImpl getById(int id) {
        return repository.getById(id);
    }
}
