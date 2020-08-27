package com.netcracker.app.domain.tariffs.repositories;

import com.netcracker.app.domain.tariffs.entities.Mobile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends TariffRepository<Mobile> {
    @Query("select m from Mobile m where m.name like :name")
    Iterable<Mobile> getAllByName(@Param("name") String name);
    @Query("select m from Mobile m where m.id = :id")
    Mobile getById(@Param("id") int id);
}
