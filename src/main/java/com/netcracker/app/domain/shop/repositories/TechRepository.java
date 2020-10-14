package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.Tech;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TechRepository extends DevicesRepository<Tech> {
    @Query(nativeQuery=true, value="select * from Tech t where regexp_like(lower(t.name), :name)")
    Page<Tech> getAllByName(@Param("name") String name, Pageable pageable);
    Page<Tech> findAll(Pageable pageable);
}
