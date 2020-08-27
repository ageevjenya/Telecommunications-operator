package com.netcracker.app.domain.info.repositories.resumes;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeImplRepository extends ResumeRepository<ResumeImpl> {
    @Query("select r from ResumeImpl r where r.id = :id")
    ResumeImpl getById(@Param("id") Integer id);
}
