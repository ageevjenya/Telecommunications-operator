package com.netcracker.app.domain.tariffs.repositories;

import com.netcracker.app.domain.tariffs.entities.TariffHome;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TariffHomeRepo extends TariffRepository<TariffHome> {
    Iterable<TariffHome> findByName(String name);
    TariffHome findById(Long id);
    @Transactional
    void deleteById(Long id);

    @Query(value = "select * from TARIFF_HOME  where speed_Internet <= :maxSpeed", nativeQuery = true)
    List<TariffHome> findBeforeMaxSpeed(@Param("maxSpeed") String maxSpeed);

}