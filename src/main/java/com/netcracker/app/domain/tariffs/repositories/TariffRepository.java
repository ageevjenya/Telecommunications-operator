package com.netcracker.app.domain.tariffs.repositories;

import com.netcracker.app.domain.tariffs.entities.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository<E extends Tariff> extends JpaRepository<E, Integer> {

}
