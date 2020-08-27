package com.netcracker.app.domain.info.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.netcracker.app.domain.info.entities.PointAcces;

import java.util.Collection;

public interface PointAccesRepo extends CrudRepository<PointAcces, Integer> {

    @Query(
            value = "SELECT PointAcces FROM PointAcces p, TypePointAcces tp WHERE p.id = tp.id AND tp.TypePointAcces IN (?1)",
            nativeQuery = true)
    Collection<PointAcces> selectPointAcces(String type);
}
