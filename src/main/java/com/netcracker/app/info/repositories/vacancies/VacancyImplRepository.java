package com.netcracker.app.info.repositories.vacancies;

import com.netcracker.app.info.entities.vacancies.VacancyImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyImplRepository extends VacancyRepository<VacancyImpl> {
    @Query("select v from VacancyImpl v where v.id = :id")
    VacancyImpl getById(@Param("id") int id);
}
