package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.Tech;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TechRepository extends DevicesRepository<Tech> {
    @Query("select m from Tech m where m.name like :name")
    Iterable<Tech> getAllByName(@Param("name") String pointName);
    @Query("select m from Tech m where m.id = :id")
    Tech getById(@Param("id") int id);
}
