package com.netcracker.app.domain.info.repositories.networkcoveragemap;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.netcracker.app.domain.info.entities.networkcoveragemap.PointAcces;
import org.springframework.data.repository.query.Param;


import java.util.Collection;
import java.util.List;


public interface PointAccesRepo extends CrudRepository<PointAcces, Integer> {

    @Query(
            value = "SELECT DISTINCT p.* FROM Point_Acces p , Type_Point_Acces tp  WHERE p.id = tp.POINTACCES_id  AND tp.Type_Point  IN (:types) ",
            nativeQuery = true)
    Collection<PointAcces> selectPointAcces(@Param("types") List<String> types);
}
