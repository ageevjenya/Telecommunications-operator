package com.netcracker.app.domain.tariffs.repositories;

import com.netcracker.app.domain.tariffs.entities.TariffOldMustDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TariffRepository<E extends TariffOldMustDelete> extends
        JpaRepository<E, Integer> {

}
