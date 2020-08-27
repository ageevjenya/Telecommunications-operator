package com.netcracker.app.info.repositories.vacancies;

import com.netcracker.app.info.entities.vacancies.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface VacancyRepository<E extends Vacancy> extends JpaRepository<E, Integer> {
}
