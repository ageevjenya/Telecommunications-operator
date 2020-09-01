package com.netcracker.app.domain.info.repositories.faq;

import com.netcracker.app.domain.info.entities.faq.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FaqRepository<E extends Faq> extends JpaRepository<E, Integer> {
}
