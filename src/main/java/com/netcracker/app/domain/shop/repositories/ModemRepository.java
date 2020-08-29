package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.Modem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModemRepository extends DevicesRepository<Modem> {
    @Query("select m from Modem m where m.name like :name")
    Iterable<Modem> getAllByName(@Param("name") String name);
    @Query("select m from Modem m where m.id = :id")
    Modem getById(@Param("id") int id);
}
