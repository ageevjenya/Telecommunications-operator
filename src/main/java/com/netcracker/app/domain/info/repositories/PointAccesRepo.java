package com.netcracker.app.domain.info.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.netcracker.app.domain.info.entities.networkcoveragemap.PointAcces;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.List;

@Repository
public interface PointAccesRepo extends CrudRepository<PointAcces, Integer> {

    @Query(
            value = "SELECT DISTINCT p.* FROM Point_Acces p , POINT_ACCES_TYPE_POINT tp  WHERE p.id = tp.POINT_ACCES_id  AND tp.Type_Point  IN (:types) ",
            nativeQuery = true)
    Iterable<PointAcces> selectPointAcces(@Param("types") List<String> types);
}
