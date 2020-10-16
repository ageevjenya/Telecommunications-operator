package com.netcracker.app.domain.info.repositories.vacancies;

import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyImplRepository extends VacancyRepository<VacancyImpl> {
    @Query("select v from VacancyImpl v where v.id = :id")
    VacancyImpl getById(@Param("id") int id);
    @Query("select v from VacancyImpl v where lower(v.name) = lower(:name)")
    VacancyImpl getByName(@Param("name") String name);
}
