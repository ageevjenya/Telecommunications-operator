package com.netcracker.app.shop.tariffs.repositories;

import com.netcracker.app.shop.tariffs.entities.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TariffRepository<E extends Tariff> extends
        JpaRepository<E, Integer> {

}
