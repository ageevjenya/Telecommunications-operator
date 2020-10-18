package com.netcracker.app.domain.info.repositories.resumes;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import com.netcracker.app.domain.users.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeImplRepository extends ResumeRepository<ResumeImpl> {
    @Query("select r from ResumeImpl r where r.id = :id")
    ResumeImpl getById(@Param("id") Integer id);
    @Query("select r from ResumeImpl r where r.vacancy = :vacancy and r.user = :user")
    ResumeImpl getByVacancyAndUser(VacancyImpl vacancy, User user);
}
