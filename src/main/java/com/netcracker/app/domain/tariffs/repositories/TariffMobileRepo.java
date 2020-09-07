package com.netcracker.app.domain.tariffs.repositories;

import com.netcracker.app.domain.tariffs.entities.TariffMobile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffMobileRepo extends TariffRepository<TariffMobile> {
    @Query("select m from TariffMobile m where m.name like :name")
    Iterable<TariffMobile> getAllByName(@Param("name") String name);
    @Query("select m from TariffMobile m where m.id = :id")
    TariffMobile getById(@Param("id") int id);
}
