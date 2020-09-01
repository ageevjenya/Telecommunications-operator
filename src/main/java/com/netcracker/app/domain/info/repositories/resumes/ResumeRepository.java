package com.netcracker.app.domain.info.repositories.resumes;

import com.netcracker.app.domain.info.entities.resumes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ResumeRepository<E extends Resume> extends JpaRepository<E, Integer> {
}
