package com.netcracker.app.domain.info.services.resumes;

import com.netcracker.app.domain.info.entities.resumes.Resume;
import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;

public interface ResumeService<E extends Resume> {
    void add(E e);
    void delete(int id) throws Exception;
    boolean existsById(int id);
    Iterable<E> getAll();
    E getById(int id) throws Exception;
    void updateVacancyId(VacancyImpl vacancy, int id) throws Exception;
    void updateFirstName(String firstName, int id) throws Exception;
    void updatePhone(String phone, int id) throws Exception;
    void updateLastName(String lastName, int id) throws Exception;
    void updateBirthDate(String birthDate, int id) throws Exception;
    void updateEmail(String email, int id) throws Exception;
    void updateText(String text, int id) throws Exception;
}
