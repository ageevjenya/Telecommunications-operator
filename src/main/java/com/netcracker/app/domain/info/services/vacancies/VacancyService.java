package com.netcracker.app.domain.info.services.vacancies;

import com.netcracker.app.domain.info.entities.vacancies.Vacancy;

public interface VacancyService<E extends Vacancy> {
    void add(E e);
    void updateName(String name, int id);
    void updateText(String text, int id);
    void delete(int id);
    boolean existsById(int id);
    Iterable<E> getAll();
    //Iterable<Vacancy> getAllByName(String name);
    E getById(int id);
}
