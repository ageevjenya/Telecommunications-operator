package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.Modem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModemRepository extends DevicesRepository<Modem> {
    @Query(nativeQuery=true, value="select * from Modem m where regexp_like(lower(m.name), :name)")
    Page<Modem> getAllByName(@Param("name") String name, Pageable pageable);
    Page<Modem> findAll(Pageable pageable);
}